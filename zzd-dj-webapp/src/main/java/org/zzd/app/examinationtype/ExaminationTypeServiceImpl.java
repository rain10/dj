package org.zzd.app.examinationtype;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.ExaminationTypeMapper;
import org.zzd.pojo.ExaminationQuestions;
import org.zzd.pojo.ExaminationType;
import org.zzd.pojo.ExaminationTypeExample;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.ExaminationTypeExample.Criteria;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

/**
 * 
* <p>Title:ExaminationTypeController </p>
* @author Arain
* @date2017年8月8日
 */
@Service
public class ExaminationTypeServiceImpl implements ExaminationTypeService{
	@Autowired
	private ExaminationTypeMapper examinationTypeMapper;
	@Override
	public ArainResult load_grid(int page, int rows, String sort, String order, String title,SysUser user) {
		JSONArray array = new JSONArray();
		ExaminationTypeExample example = new ExaminationTypeExample();
		Criteria criteria = example.createCriteria().andOrgidEqualTo(user.getOrgid());
		if (StringUtils.isNotBlank(order)) {
			example.setOrderByClause(sort + " " + order);
		} else {
			example.setOrderByClause(sort);
		}
		if (StringUtils.isNotBlank(title)) {
			criteria.andTitleLike("%" + title + "%");
		}
		PageHelper.startPage(page, rows);
		List<ExaminationType> list = examinationTypeMapper.selectByExample(example);
		int count = examinationTypeMapper.countByExample(example);
		for (ExaminationType examinationType : list) {
			JSONObject object = new JSONObject();
			object.put("ID_", examinationType.getId());
			object.put("title_", examinationType.getTitle());
			object.put("manager_", examinationType.getManager());
			object.put("manager_time_", TimeUtil.format(examinationType.getManagerTime()));
			object.put("enabled",
					DictUtil.load_dict(examinationType.getEnabled().toString(), "ENABLED_").getDispaly());

			array.add(object);
		}
		JSONObject object = new JSONObject();
		object.put("total", count);
		object.put("rows", array);
		return ArainResult.ok(object);
	}
	@Override
	public ArainResult save_01(ExaminationType type) {
		if(type.getId()!=null) {
			examinationTypeMapper.updateByPrimaryKey(type);
			return ArainResult.ok();
		}
		examinationTypeMapper.insert(type);
		return ArainResult.ok();
	}
	@Override
	public ArainResult edit_01(ExaminationType type) {
		ExaminationType examinationType = examinationTypeMapper.selectByPrimaryKey(type.getId());
		return ArainResult.ok(examinationType);
	}
	@Override
	public ArainResult load_type(ExaminationQuestions questions,SysUser user) {
		JSONArray array = new JSONArray();
		ExaminationTypeExample example = new ExaminationTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEnabledEqualTo(1).andOrgidEqualTo(user.getOrgid());
		
		List<ExaminationType> list = examinationTypeMapper.selectByExample(example);
		for (ExaminationType examinationType : list) {
			JSONObject object = new JSONObject();
			object.put("id", examinationType.getId());
			object.put("text", examinationType.getTitle());
			
			array.add(object);
		}
		
		return ArainResult.ok(array);
	}

}
