package org.zzd.app.exam;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.ExaminationMapper;
import org.zzd.mapper.ExaminationUserMapper;
import org.zzd.pojo.Examination;
import org.zzd.pojo.ExaminationExample;
import org.zzd.pojo.ExaminationExample.Criteria;
import org.zzd.pojo.ExaminationUserExample;
import org.zzd.pojo.ExaminationWithBLOBs;
import org.zzd.pojo.SysUser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

/**
 * 
* <p>Title:ExamServiceImpl </p>
* @author Arain
* @date2017年8月11日
 */
@Service
public class ExamServiceImpl implements ExamService{
	@Autowired
	private ExaminationMapper examinationMapper;
	@Autowired
	private ExaminationUserMapper examinationUserMapper;
	@Override
	public ArainResult load_grid(int page, int rows, String sort, String order, String title, Integer type,SysUser user) {
		JSONArray array = new JSONArray();
		ExaminationExample example = new ExaminationExample();
		Criteria criteria = example.createCriteria().andOrgidEqualTo(user.getOrgid());
		if (StringUtils.isNotBlank(order)) {
			example.setOrderByClause(sort + " " + order);
		} else {
			example.setOrderByClause(sort);
		}
		if (StringUtils.isNotBlank(title)) {
			criteria.andTitleLike("%" + title + "%");
		}
		if (type != null) {
			criteria.andTypeEqualTo(type);
		}
		List<Examination> list = examinationMapper.selectByExample(example);
		int count = examinationMapper.countByExample(example);
		for (Examination examination : list) {
				JSONObject object = new JSONObject();
				object.put("ID_", examination.getId());
				object.put("title_",examination.getTitle());
				object.put("start_time_",TimeUtil.format(examination.getStartTime()));
				object.put("end_time_",TimeUtil.format(examination.getEndTime()));
				object.put("manager_", examination.getManager());
				object.put("maneger_time_",TimeUtil.format(examination.getManagerTime()));
				object.put("ing_", DictUtil.load_dict(examination.getIng().toString(),"ing").getDispaly());
				object.put("type_", DictUtil.load_dict(examination.getType().toString(),"examType").getDispaly());
				object.put("enabled_",DictUtil.load_dict(examination.getEnabled().toString(),"ENABLED_").getDispaly());
				
				array.add(object);
		}
		JSONObject object = new JSONObject();
		object.put("total",count);
		object.put("rows", array);
		return ArainResult.ok(object);
	}
	
	@CacheEvict(value="examcache",allEntries=true,beforeInvocation=true)
	@Override
	public ArainResult save_01(ExaminationWithBLOBs examination) {
		String now = TimeUtil.getNow(TimeUtil.FORMAT_INT);
		String start = TimeUtil.format(examination.getStartTime(), TimeUtil.FORMAT_INT);
		String end = TimeUtil.format(examination.getEndTime(), TimeUtil.FORMAT_INT);
		if(Long.valueOf(start) > Long.valueOf(end)) {
			return ArainResult.build(400, "您的结束时间小于开始时间！");
		}
		
		if(Long.valueOf(now)>=Long.valueOf(start) &&Long.valueOf(now)<Long.valueOf(end)) {
			examination.setIng(1);
		}
		if(Long.valueOf(now)<Long.valueOf(start)) {
			examination.setIng(0);
		}
		
		if(Long.valueOf(now)>Long.valueOf(end)) {
			return ArainResult.build(400, "您的结束时间小于当前时间！");
		}
		if(examination.getId()!=null) {
			examinationMapper.updateByPrimaryKeyWithBLOBs(examination);
		} else {
			examinationMapper.insert(examination);
		}
		return ArainResult.ok();
	}

	@Override
	public ArainResult load_01(ExaminationWithBLOBs examination) {
		examination = examinationMapper.selectByPrimaryKey(examination.getId());
		return ArainResult.ok(examination);
	}

	@Override
	public ArainResult load_exam_user(SysUser user) {
		JSONArray array = new JSONArray();
		JSONArray countArr = new JSONArray();
		JSONArray name = new JSONArray();
		ExaminationExample example = new ExaminationExample();
		example.setOrderByClause("manager_time_ desc");
		example.createCriteria().andEnabledEqualTo(1).andOrgidEqualTo(user.getOrgid());
		PageHelper.startPage(1,11);
		List<Examination> list = examinationMapper.selectByExample(example);
		for (int i = 0; i < list.size(); i++) {
			JSONObject object = new JSONObject();
			object.put("symbolSize", 20);
			object.put("name",list.get(i).getTitle());
			object.put("symbol","image://../admin/img/star.png");
			object.put("y",350);
			object.put("xAxis", i);
			
			array.add(object);
			
			name.add(list.get(i).getTitle());
			
			ExaminationUserExample exUserExample = new ExaminationUserExample();
			exUserExample.createCriteria().andExamIdEqualTo(list.get(i).getId());
			int count = examinationUserMapper.countByExample(exUserExample);
			
			countArr.add(count);
		}
			
		JSONObject object = new JSONObject();
		object.put("statistics", array);
		object.put("count", countArr);
		object.put("name", name);	
		
		return ArainResult.ok(object);
	}

}
