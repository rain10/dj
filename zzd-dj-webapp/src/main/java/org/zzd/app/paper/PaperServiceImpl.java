package org.zzd.app.paper;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.CommonUtil;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.ExaminationPaperMapper;
import org.zzd.mapper.ExaminationQuestionsMapper;
import org.zzd.mapper.PaperQuestionMapper;
import org.zzd.pojo.ExaminationPaper;
import org.zzd.pojo.ExaminationPaperExample;
import org.zzd.pojo.ExaminationPaperExample.Criteria;
import org.zzd.pojo.ExaminationQuestions;
import org.zzd.pojo.ExaminationQuestionsExample;
import org.zzd.pojo.PaperQuestionExample;
import org.zzd.pojo.PaperQuestionKey;
import org.zzd.pojo.SysUser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

/**
 * 
 * <p>
 * Title:PaperServiceImpl
 * </p>
 * 
 * @author Arain
 * @date2017年8月9日
 */
@Service
public class PaperServiceImpl implements PaperService {
	@Autowired
	private ExaminationPaperMapper examinationPaperMapper;
	@Autowired
	private PaperQuestionMapper paperQuestionMapper;
	@Autowired
	private ExaminationQuestionsMapper examinationQuestionsMapper;

	@Override
	public ArainResult load_grid(int page, int rows, String sort, String order, String title,SysUser user) {
		JSONArray array = new JSONArray();
		ExaminationPaperExample example = new ExaminationPaperExample();
		Criteria criteria = example.createCriteria().andOrgidEqualTo(user.getOrgid());
		if (StringUtils.isNotBlank(order)) {
			example.setOrderByClause(sort + " " + order);
		} else {
			example.setOrderByClause(sort);
		}
		if (StringUtils.isNotBlank(title)) {
			criteria.andTitleLike("%" + title + "%");
		}
		// PageHelper.startPage(page, rows);
		List<ExaminationPaper> list = examinationPaperMapper.selectByExample(example);
		int count = examinationPaperMapper.countByExample(example);
		for (ExaminationPaper examinationPaper : list) {
			JSONObject object = new JSONObject();
			object.put("ID_", examinationPaper.getId());
			object.put("title_", examinationPaper.getTitle());
			object.put("manager_", examinationPaper.getManager());
			object.put("manager_time_", TimeUtil.format(examinationPaper.getManagerTime()));
//			object.put("ing_", DictUtil.load_dict(examinationPaper.getIng().toString(), "ENABLED_").getDispaly());
			object.put("enabled_",
					DictUtil.load_dict(examinationPaper.getEnabled().toString(), "ENABLED_").getDispaly());

			array.add(object);
		}
		JSONObject object = new JSONObject();
		object.put("total", count);
		object.put("rows", array);
		return ArainResult.ok(object);
	}

	@Override
	public ArainResult save_01(ExaminationPaper paper, String questions) {
		if (paper.getId() != null) {
			int i = examinationPaperMapper.updateByPrimaryKey(paper);
			if (i == 1) {
				PaperQuestionExample example = new PaperQuestionExample();
				example.createCriteria().andPaperIdEqualTo(paper.getId());
				paperQuestionMapper.deleteByExample(example);
				if (StringUtils.isNotBlank(questions)) {
					String[] arr = questions.split(",");
					for (String string : arr) {
						PaperQuestionKey paperQuestionKey = new PaperQuestionKey();
						paperQuestionKey.setQuestionId(Long.valueOf(string));
						paperQuestionKey.setPaperId(paper.getId());

						paperQuestionMapper.insert(paperQuestionKey);
					}
				}
				return ArainResult.ok();
			}
			return ArainResult.build(400, "信息错误");
		} else {
			int i = examinationPaperMapper.insert(paper);
			if (i == 1) {
				if (StringUtils.isNotBlank(questions)) {
					String[] arr = questions.split(",");
					for (String string : arr) {
						PaperQuestionKey paperQuestionKey = new PaperQuestionKey();
						paperQuestionKey.setQuestionId(Long.valueOf(string));
						paperQuestionKey.setPaperId(paper.getId());

						paperQuestionMapper.insert(paperQuestionKey);
					}
				}
				return ArainResult.ok();
			}
			return ArainResult.build(400, "信息错误");
		}
	}

	@Override
	public ArainResult edit_01(ExaminationPaper paper) {
		paper = examinationPaperMapper.selectByPrimaryKey(paper.getId());
		return ArainResult.ok(paper);
	}

	@Override
	public ArainResult load_quesyion_id(ExaminationPaper paper) {
		JSONArray array = new JSONArray();
		StringBuffer buffer = new StringBuffer();
		PaperQuestionExample example = new PaperQuestionExample();
		org.zzd.pojo.PaperQuestionExample.Criteria criteria = example.createCriteria();
		criteria.andPaperIdEqualTo(paper.getId());
		List<PaperQuestionKey> list = paperQuestionMapper.selectByExample(example);
		for (PaperQuestionKey paperQuestionKey : list) {
			// JSONObject object = new JSONObject();
			// object.put("qid", paperQuestionKey.getQuestionId());
			// array.add(object);
			buffer.append(paperQuestionKey.getQuestionId() + ",");
		}

		return ArainResult.ok(buffer.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArainResult save_suiji(ExaminationPaper paper, Integer count) {
		paper.setEnabled(1);
		int i = examinationPaperMapper.insert(paper);
		if (i == 1) {
			if(count != null) {
				ExaminationQuestionsExample example = new ExaminationQuestionsExample();
				example.createCriteria().andEnabledEqualTo(1);
				List<ExaminationQuestions> list = examinationQuestionsMapper.selectByExample(example);
				if(list!=null && list.size()>0) {
					List<ExaminationQuestions> randomList = CommonUtil.getRandomList(list, count);
					for (ExaminationQuestions examinationQuestions : randomList) {
						PaperQuestionKey paperQuestionKey = new PaperQuestionKey();
						paperQuestionKey.setQuestionId(examinationQuestions.getId());
						paperQuestionKey.setPaperId(paper.getId());

						paperQuestionMapper.insert(paperQuestionKey);
					}
				}
			}
			
			return ArainResult.ok();
		}
		return ArainResult.build(400, "信息错误");
	}

	@Override
	public ArainResult load_combogrid(int page, int rows, String title,SysUser user) {
		JSONArray array = new JSONArray();
		ExaminationPaperExample example = new ExaminationPaperExample();
		Criteria criteria = example.createCriteria().andEnabledEqualTo(1).andOrgidEqualTo(user.getOrgid());
		if(StringUtils.isNotBlank(title)) {
			criteria.andTitleLike("%"+title+"%");
		}
		
		PageHelper.startPage(page, rows);
		List<ExaminationPaper> list = examinationPaperMapper.selectByExample(example);
		int count = examinationPaperMapper.countByExample(example);
		for (ExaminationPaper examinationPaper : list) {
			JSONObject object = new JSONObject();
			object.put("id_", examinationPaper.getId());
			object.put("title_", examinationPaper.getTitle());
			object.put("manager_time_", TimeUtil.format(examinationPaper.getManagerTime()));
			array.add(object);
		}
		JSONObject object = new JSONObject();
		object.put("total", count);
		object.put("rows", array);
		return ArainResult.ok(object);
	}

}
