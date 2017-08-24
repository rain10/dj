package org.zzd.common.util;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zzd.common.pojo.DictPojo;
import org.zzd.mapper.SysDictionaryMapper;
import org.zzd.pojo.SysDictionary;
import org.zzd.pojo.SysDictionaryExample;
import org.zzd.pojo.SysDictionaryExample.Criteria;

@Component
public class DictUtil {
	@Autowired
	private  SysDictionaryMapper sysDictionaryMapper;
	
	private static DictUtil load_dict;
	
	@PostConstruct
	public void init() {
		load_dict = this;
		load_dict.sysDictionaryMapper= this.sysDictionaryMapper;
	}
	
	public static  DictPojo load_dict(String value,String type) {
		DictPojo dictPojo = new DictPojo();
		SysDictionaryExample example = new SysDictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type).andValueEqualTo(value);
		List<SysDictionary> list = load_dict.sysDictionaryMapper.selectByExample(example);
		for (SysDictionary sysDictionary : list) {
			dictPojo.setType(sysDictionary.getType());
			dictPojo.setValue(sysDictionary.getValue());
			dictPojo.setDispaly(sysDictionary.getDisplay());
		}
		return dictPojo;
	}
	
	
	public static List<DictPojo> load_dict_list(String type) {
		List<DictPojo> dictPojos = new ArrayList<>();
		SysDictionaryExample example = new SysDictionaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type);
		List<SysDictionary> list = load_dict.sysDictionaryMapper.selectByExample(example);
		for (SysDictionary sysDictionary : list) {
			DictPojo dictPojo = new DictPojo();
			dictPojo.setType(sysDictionary.getType());
			dictPojo.setValue(sysDictionary.getValue());
			dictPojo.setDispaly(sysDictionary.getDisplay());
			
			dictPojos.add(dictPojo);
		}
		return dictPojos;
	}
}
