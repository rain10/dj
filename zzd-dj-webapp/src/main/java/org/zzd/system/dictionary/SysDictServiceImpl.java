package org.zzd.system.dictionary;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.mapper.SysDictionaryMapper;
import org.zzd.pojo.SysDictionary;
import org.zzd.pojo.SysDictionaryExample;
import org.zzd.pojo.SysDictionaryExample.Criteria;

import com.github.pagehelper.PageHelper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
* <p>Title:SysDictServiceImpl </p>
* @author Arain
* @date2017年6月8日
 */
@Service
public class SysDictServiceImpl implements SysDictService{
	@Autowired
	private SysDictionaryMapper sysDictionaryMapper;

	@Override
	public String load_datagrid(int page, int rows,Integer enable,String name,String type,String sort) {
		JSONArray array = new JSONArray();
		JSONObject out = new JSONObject();
		SysDictionaryExample example = new SysDictionaryExample();
		example.setOrderByClause(sort);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(name)) {
			criteria.andNameLike("%"+name+"%");
		}
		
		if(StringUtils.isNotBlank(type)) {
			criteria.andTypeLike("%"+type+"%");
		}
		
		if(enable != null) {
			criteria.andEnabledEqualTo(enable);
		}
		PageHelper.startPage(page, rows);
		List<SysDictionary> list = sysDictionaryMapper.selectByExample(example);
		int count = sysDictionaryMapper.countByExample(example);
		for (SysDictionary sysDictionary : list) {
			JSONObject object = new JSONObject();
			object.accumulate("TYPE_", sysDictionary.getType());
			object.accumulate("NAME_", sysDictionary.getName());
			object.accumulate("VALUE_", sysDictionary.getValue());
			object.accumulate("DISPLAY_", sysDictionary.getDisplay());
			object.accumulate("ENABLED_", DictUtil.load_dict(sysDictionary.getEnabled().toString(),"ENABLED_").getDispaly());
			object.accumulate("SORT_", sysDictionary.getSort());
			
			array.add(object);
		}
		out.accumulate("total", count);
		out.accumulate("rows", array);
		
		return out.toString();
	}

	@Override
	public ArainResult save_01(SysDictionary sysDictionary,String actionType) {
		if(StringUtils.isNotBlank(actionType)) {
			SysDictionaryExample example = new SysDictionaryExample();
			example.createCriteria().andTypeEqualTo(sysDictionary.getType()).andValueEqualTo(sysDictionary.getValue());
			sysDictionaryMapper.updateByPrimaryKey(sysDictionary);
			return ArainResult.ok();
		}
		sysDictionaryMapper.insert(sysDictionary);
		return ArainResult.ok();
	}

	@Override
	public ArainResult load_01(SysDictionary sysDictionary) {
		SysDictionaryExample example = new SysDictionaryExample();
		example.createCriteria().andTypeEqualTo(sysDictionary.getType()).andValueEqualTo(sysDictionary.getValue());
		List<SysDictionary> list = sysDictionaryMapper.selectByExample(example);
		return ArainResult.ok(list.get(0));
	}
}
