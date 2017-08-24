package org.zzd.system.role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysRole;
import org.zzd.pojo.SysUser;

@Controller
@RequestMapping("system/role")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping("list_01")
	public String load_list(HttpServletRequest request,Model model) {
		return "system/role/list_01";
	}
	
	
	@RequestMapping(value="load_datagrid.do", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10") int rows, String sort,String order,String name,Short enable) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult arainResult = sysRoleService.load_list(page, rows, sort, order,name,enable,user);
		String array = (String) arainResult.getData();
		return array;
	}
	
	@RequestMapping("add_01")
	public String load_add() {
		return "system/role/add_01";
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public ArainResult save_01(SysRole sysRole,String resourceIds,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult save_01 = sysRoleService.save_01(sysRole,resourceIds,user);
		return save_01;
	}
	
	@RequestMapping("edit_01")
	public String load_edit(Model model,SysRole sysRole,HttpServletRequest request) {
		ArainResult result = sysRoleService.load_01(sysRole);
		SysRole data = (SysRole) result.getData();
		model.addAttribute("sysRole", data);
		return "system/role/add_01";
	}
	
}
