package org.zzd.system.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/**
 * 
 * 
* <p>Title:SysDictController </p>
* @author Arain
* @date2017年6月8日
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysDictionary;

@Controller
@RequestMapping("system/dict")
public class SysDictController {
	@Autowired
	private SysDictService sysDictService;
	
	
	@RequestMapping("list_01")
	public String load_list() {
		return "system/dict/list_01";
	}
	
	@RequestMapping(value="load_datagrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_datagrid(int page,int rows,Integer enable,String name,String type,String sort) {
		String datagrid = sysDictService.load_datagrid(page, rows, enable, name, type,sort);
		return datagrid;
		
	}
	
	@RequestMapping("add_01")
	public String load_add() {
		
		return "system/dict/add_01";
	}
	
	@RequestMapping("edit_01")
	public String load_edit_01(SysDictionary sysDictionary,Model model) {
		ArainResult result = sysDictService.load_01(sysDictionary);
		model.addAttribute("type", "editsave");
		model.addAttribute("dict", result.getData());
		return "system/dict/add_01";
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public ArainResult save_01(SysDictionary sysDictionary,String actionType) {
		ArainResult save_01 = sysDictService.save_01(sysDictionary,actionType);
		return save_01;
	}
}
