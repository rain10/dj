package org.zzd.app.examination;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.ExaminationAnswerMapper;
import org.zzd.mapper.ExaminationQuestionsMapper;
import org.zzd.pojo.ExaminationAnswer;
import org.zzd.pojo.ExaminationAnswerExample;
import org.zzd.pojo.ExaminationQuestions;
import org.zzd.pojo.ExaminationQuestionsExample;
import org.zzd.pojo.SysResource;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.ExaminationQuestionsExample.Criteria;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

/**
 * 
 * <p>
 * Title:ExaminationServiceImpl
 * </p>
 * 
 * @author Arain
 * @date2017年8月7日
 */
@Service
public class ExaminationServiceImpl implements ExaminationService {
	@Autowired
	private ExaminationQuestionsMapper examinationQuestionsMapper;
	@Autowired
	private ExaminationAnswerMapper examinationAnswerMapper;

	@Override
	public ArainResult load_grid(int page, int rows, String sort, String order, String title, String type,SysUser user) {
		JSONArray array = new JSONArray();
		ExaminationQuestionsExample example = new ExaminationQuestionsExample();

		Criteria criteria = example.createCriteria().andOrgidEqualTo(user.getOrgid());
//		criteria.andEnabledEqualTo(1);

		if (StringUtils.isNotBlank(order)) {
			example.setOrderByClause(sort + " " + order);
		} else {
			example.setOrderByClause(sort);
		}
		if (StringUtils.isNotBlank(title)) {
			criteria.andTitleLike("%" + title + "%");
		}
		if (type != null) {
			criteria.andTypeLike("%" + type + "%");
		}
		PageHelper.startPage(page, rows);
		List<ExaminationQuestions> list = examinationQuestionsMapper.selectByExample(example);
		int count = examinationQuestionsMapper.countByExample(example);
		for (ExaminationQuestions examinationQuestions : list) {
			String type3 = examinationQuestions.getType();
			
			String type2 = examinationQuestions.getType();
			JSONObject object = new JSONObject();
			object.put("ID_", examinationQuestions.getId());
			object.put("title_", examinationQuestions.getTitle());
			object.put("manager_", examinationQuestions.getManager());
			object.put("manager_time_", TimeUtil.format(examinationQuestions.getManagerTime()));
			object.put("enabled_",
					DictUtil.load_dict(examinationQuestions.getEnabled().toString(), "ENABLED_").getDispaly());

			if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(type2)) {
				String[] split2 = type.split(",");
				String[] split = type2.split(",");
				in:for (String string : split) {
					for (String string1 : split2) {
						if(string1.equals(string)) {
							array.add(object);
							break in;
						}
					}
				}
			} else {
				array.add(object);
			}
		}
		JSONObject object = new JSONObject();
		object.put("total",count);
		object.put("rows", array);
		return ArainResult.ok(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArainResult save_01(ExaminationQuestions questions, String answerJson) {
		if (questions.getId() != null) {
			int i = examinationQuestionsMapper.updateByPrimaryKey(questions);
			StringBuffer buffer = new StringBuffer();
			if (answerJson != null && i == 1) {
				net.sf.json.JSONArray array = net.sf.json.JSONArray.fromObject(answerJson);
				List<AnswerPojo> collection = (List<AnswerPojo>) net.sf.json.JSONArray.toCollection(array,
						AnswerPojo.class);
				ExaminationAnswerExample example = new ExaminationAnswerExample();
				example.createCriteria().andQuestionIdEqualTo(questions.getId());
				examinationAnswerMapper.deleteByExample(example);
				if (collection != null && collection.size() > 0) {
					for (AnswerPojo answerPojo : collection) {
						ExaminationAnswer answer = new ExaminationAnswer();
						answer.setOption(answerPojo.getOption());
						answer.setContent(answerPojo.getContent());
						answer.setQuestionId(questions.getId());
						answer.setEnabled(1);
						examinationAnswerMapper.insert(answer);
						if (answerPojo.getAnswer() == 1) {
							buffer.append(answer.getId() + ",");
						}
					}

				}
				questions.setAnswer(buffer.toString());
				examinationQuestionsMapper.updateByPrimaryKey(questions);
			}

			return ArainResult.ok();
		} else {
			int i = examinationQuestionsMapper.insert(questions);
			StringBuffer buffer = new StringBuffer();
			if (answerJson != null && i == 1) {
				net.sf.json.JSONArray array = net.sf.json.JSONArray.fromObject(answerJson);
				List<AnswerPojo> collection = (List<AnswerPojo>) net.sf.json.JSONArray.toCollection(array,
						AnswerPojo.class);
				if (collection != null && collection.size() > 0) {
					for (AnswerPojo answerPojo : collection) {
						ExaminationAnswer answer = new ExaminationAnswer();
						answer.setOption(answerPojo.getOption());
						answer.setContent(answerPojo.getContent());
						answer.setQuestionId(questions.getId());
						answer.setEnabled(1);
						examinationAnswerMapper.insert(answer);
						if (answerPojo.getAnswer() == 1) {
							buffer.append(answer.getId() + ",");
						}
					}

				}
				questions.setAnswer(buffer.toString());
				examinationQuestionsMapper.updateByPrimaryKey(questions);
			}
			return ArainResult.ok();
		}
	}

	@Override
	public ArainResult edit_01(ExaminationQuestions questions) {
		ExaminationQuestions examinationQuestions = examinationQuestionsMapper.selectByPrimaryKey(questions.getId());
		return ArainResult.ok(examinationQuestions);
	}

	@Override
	public ArainResult load_edit_grid(ExaminationAnswer answer) {
		ExaminationQuestions questions = examinationQuestionsMapper.selectByPrimaryKey(answer.getQuestionId());
		String answer2 = questions.getAnswer();

		JSONArray array = new JSONArray();
		ExaminationAnswerExample example = new ExaminationAnswerExample();
		org.zzd.pojo.ExaminationAnswerExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andQuestionIdEqualTo(answer.getQuestionId()).andEnabledEqualTo(1);
		List<ExaminationAnswer> list = examinationAnswerMapper.selectByExample(example);
		for (ExaminationAnswer examinationAnswer : list) {
			JSONObject object = new JSONObject();
			object.put("name", examinationAnswer.getOption());
			object.put("target", examinationAnswer.getContent());

			if (answer2 != null) {
				String[] strings = answer2.split(",");
				in: for (String string : strings) {
					if (examinationAnswer.getId() == Long.valueOf(string)) {
						object.put("answer", 1);
						break in;
					} else {
						object.put("answer", 0);
					}
				}
			}
			array.add(object);
		}
		return ArainResult.ok(array);
	}

	@Override
	public ArainResult paper_load_grid(int page, int rows, String sort, String order, String title, String type,SysUser user) {
		JSONArray array = new JSONArray();
		ExaminationQuestionsExample example = new ExaminationQuestionsExample();

		Criteria criteria = example.createCriteria().andOrgidEqualTo(user.getOrgid());
		criteria.andEnabledEqualTo(1);

		if (StringUtils.isNotBlank(order)) {
			example.setOrderByClause(sort + " " + order);
		} else {
			example.setOrderByClause(sort);
		}
		if (StringUtils.isNotBlank(title)) {
			criteria.andTitleLike("%" + title + "%");
		}
		if (type != null) {
			criteria.andTypeLike("%" + type + "%");
		}
		PageHelper.startPage(page, rows);
		List<ExaminationQuestions> list = examinationQuestionsMapper.selectByExample(example);
		int count = examinationQuestionsMapper.countByExample(example);
		for (ExaminationQuestions examinationQuestions : list) {
			String type2 = examinationQuestions.getType();
			JSONObject object = new JSONObject();
			object.put("ID_", examinationQuestions.getId());
			object.put("title_", examinationQuestions.getTitle());
			object.put("manager_", examinationQuestions.getManager());
			object.put("manager_time_", TimeUtil.format(examinationQuestions.getManagerTime()));
			object.put("enabled",
					DictUtil.load_dict(examinationQuestions.getEnabled().toString(), "ENABLED_").getDispaly());

			if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(type2)) {
				String[] split2 = type.split(",");
				String[] split = type2.split(",");
				in:for (String string : split) {
					for (String string1 : split2) {
						if(string1.equals(string)) {
							array.add(object);
							break in;
						}
					}
				}
			} else {
				array.add(object);
			}
			
		}
		JSONObject object = new JSONObject();
		object.put("total",count);
		object.put("rows", array);
		return ArainResult.ok(object);
	}

}
