package org.zzd.system.common;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.pojo.DictPojo;
import org.zzd.common.util.DictUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 
* <p>Title:DictionaryController </p>
* @author Arain
* @date2017年5月19日
 */
@Controller
@RequestMapping("system/dictionary")
public class DictionaryController {
	
	
	@RequestMapping(value="load_enabled.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String enabled() {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		object.accumulate("id", 1);
		object.accumulate("etext", "可用");
		
		JSONObject object1 = new JSONObject();
		object1.accumulate("id", 0);
		object1.accumulate("etext", "不可用");
		
		array.add(object);
		array.add(object1);
		return array.toString();
	}
	
	@RequestMapping(value="load_enabled2.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String enabled_02() {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		object.accumulate("id", 1);
		object.accumulate("text", "是");
		
		JSONObject object1 = new JSONObject();
		object1.accumulate("id", 0);
		object1.accumulate("text", "否");
		
		array.add(object1);
		array.add(object);
		return array.toString();
	}
	
	
	@RequestMapping(value="load_power.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String power() {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		object.accumulate("id", 1);
		object.accumulate("ptext", "授权");
		
		JSONObject object1 = new JSONObject();
		object1.accumulate("id", 0);
		object1.accumulate("ptext", "不授权");
		
		array.add(object);
		array.add(object1);
		return array.toString();
	}
	
	@RequestMapping(value="load_GD0205.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_GD0205(String type) {
		JSONArray array = new JSONArray();
		List<DictPojo> list = DictUtil.load_dict_list(type);
		for (DictPojo dictPojo : list) {
			JSONObject object = new JSONObject();
			object.accumulate("id", dictPojo.getValue());
			object.accumulate("text", dictPojo.getDispaly());
			
			array.add(object);
		}
		return array.toString();
	}
	
	@RequestMapping(value="load_exam_type.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String exam_type() {
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		object.accumulate("id", 1);
		object.accumulate("text", "正式考试");
		
		JSONObject object1 = new JSONObject();
		object1.accumulate("id", 0);
		object1.accumulate("text", "测试");
		
		JSONObject object2 = new JSONObject();
		object2.accumulate("id", 2);
		object2.accumulate("text", "问卷调查");
		
		array.add(object);
		array.add(object1);
		array.add(object2);
		return array.toString();
	}
	
	
	@RequestMapping(value="load_group_type.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String group_type() {
		com.alibaba.fastjson.JSONArray array = new com.alibaba.fastjson.JSONArray();
		List<DictPojo> list = DictUtil.load_dict_list("groupType");
		for (DictPojo dictPojo : list) {
			com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
			jsonObject.put("id", dictPojo.getValue());
			jsonObject.put("text", dictPojo.getDispaly());
			
			array.add(jsonObject);
		}
		return array.toString();
	}
	
}
