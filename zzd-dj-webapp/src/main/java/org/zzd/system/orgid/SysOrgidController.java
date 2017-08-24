package org.zzd.system.orgid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysOrganization;


/**
 * 
* <p>Title:SysOrgidController </p>
* @author Arain
* @date2017年6月8日
 */
@Controller
@RequestMapping("system/orgid")
public class SysOrgidController {
	@Autowired
	private SysOrgidService sysOrgidService;
	
	@RequestMapping("list_01")
	public String load_list(Model model) {
		String map = sysOrgidService.load_map();
		model.addAttribute("mapArray", map);
		return "system/orgid/list_01";
	}
	
	@RequestMapping(value="load_datagrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_data(Long city) {
		String datagrid = sysOrgidService.load_datagrid(city);
		return datagrid;
	}
	
	@RequestMapping("add_01")
	public String load_add() {
		return "system/orgid/add_01";
	}
	
	
	@RequestMapping(value="load_tree",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_tree() {
		String datagrid = sysOrgidService.load_tree();
		return datagrid;
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public ArainResult save_01(SysOrganization sysOrganization) {
		ArainResult result = sysOrgidService.save_01(sysOrganization);
		return result;
	}
	
	@RequestMapping("edit_01")
	public String load_edit(SysOrganization sysOrganization,Model model) {
		ArainResult result = sysOrgidService.load_01(sysOrganization);
		model.addAttribute("orgid", result.getData());
		return "system/orgid/add_01";
	}
}
