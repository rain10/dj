package org.zzd.system.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.pojo.RoleResult;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.JsonUtils;
import org.zzd.pojo.SysRole;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.SysUserRoleKey;
import org.zzd.system.role.SysRoleService;

import net.sf.json.JSONObject;

/**
 * 
* <p>Title:UserController </p>
* @author Arain
* @date2017年5月22日
 */
@Controller
@RequestMapping("system/user")
public class SysUserController {
	@Autowired
	private SysUserService userService;
	@Autowired
	private SysRoleService sysRoleService;
	

	@RequestMapping("list_01")
	public String load_list(HttpServletRequest request,Model model) {
		return "system/user/list_01";
	}
	
	@RequestMapping(value="load_datagrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(HttpServletRequest request,HttpServletResponse response,@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10") int rows, String sort,String order,String username,Short enable,String realname,Short type) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult arainResult = userService.load_list(page, rows, sort, order, username, enable, realname,user,type);
		String array = (String) arainResult.getData();
		return array;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("add_01")
	public String add_01(HttpServletRequest request,Model model) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		Long orgid = userService.load_first_orgid(user);
		ArainResult list = sysRoleService.load_list(user);
		List<SysRole> data = (List<SysRole>) list.getData();
		List<RoleResult> rolerList = new ArrayList<>();
		for (SysRole sysRole : data) {
			RoleResult roleResult = new RoleResult();
			roleResult.setName(sysRole.getName());
			roleResult.setId(sysRole.getId());
			roleResult.setChecked("");
			rolerList.add(roleResult);
		}
		model.addAttribute("roles", rolerList);
		model.addAttribute("orgid", orgid);
		return "system/user/add_01";
	}
	
	
	@RequestMapping(value="save.do")
	@ResponseBody
	public ArainResult save_01(SysUser sysUser,String [] roles) {
		ArainResult result = userService.save_01(sysUser,roles);
		return result;
	}
	
	@RequestMapping("edit_01")
	public String edit_01(SysUser sysUser,HttpServletRequest request,Model model) {
		SysUser user1 = (SysUser) request.getSession().getAttribute("userInfo");
		Long orgid = userService.load_first_orgid(user1);
		ArainResult result = userService.load_01(sysUser);
		List<SysRole> sysRoles = new ArrayList<>();
		JSONObject data = (JSONObject) result.getData();
		Object object = data.get("sysUser");
		
		SysUser user = JsonUtils.jsonToPojo(object.toString(), SysUser.class);
		Object object2 = data.get("sysRole");
		List<SysUserRoleKey> roleKey = JsonUtils.jsonToList(object2.toString(), SysUserRoleKey.class);
		for (SysUserRoleKey sysUserRoleKey : roleKey) {
			SysRole sysRole = new SysRole();
			sysRole.setId(sysUserRoleKey.getRoleId());
			ArainResult arainResult = sysRoleService.load_01(sysRole);
			SysRole role = (SysRole) arainResult.getData();
			sysRoles.add(role);
		}
		
		ArainResult list = sysRoleService.load_list(user1);
		List<SysRole> allRole = (List<SysRole>) list.getData();
		
		List<RoleResult> rolerList = new ArrayList<>();
		for (SysRole sysRole : allRole) {
			RoleResult roleResult = new RoleResult();
			roleResult.setName(sysRole.getName());
			roleResult.setId(sysRole.getId());
			rolerList.add(roleResult);
		}
		
		for (int i = 0; i < rolerList.size(); i++) {
			in:for (int j = 0; j < sysRoles.size(); j++) {
				if (rolerList.get(i).getId().toString().equals(sysRoles.get(j).getId().toString())) {
					rolerList.get(i).setChecked("checked");
					break in;
				} 
			}
			
		}
		model.addAttribute("orgid", orgid);
		model.addAttribute("roles", rolerList);
		model.addAttribute("sysUser",user);
		return "system/user/add_01";
	}
	
	
	
	
	@RequestMapping("list_02")
	public String load_list_02(HttpServletRequest request,Model model) {
		return "system/user/list_02";
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("add_02")
	public String add_02(HttpServletRequest request,Model model) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		Long orgid = userService.load_first_orgid(user);
		ArainResult list = sysRoleService.load_list(user);
		List<SysRole> data = (List<SysRole>) list.getData();
		List<RoleResult> rolerList = new ArrayList<>();
		for (SysRole sysRole : data) {
			RoleResult roleResult = new RoleResult();
			roleResult.setName(sysRole.getName());
			roleResult.setId(sysRole.getId());
			roleResult.setChecked("");
			rolerList.add(roleResult);
		}
		model.addAttribute("roles", rolerList);
		model.addAttribute("orgid", orgid);
		return "system/user/add_02";
	}
	
	@RequestMapping("edit_02")
	public String edit_02(SysUser sysUser,HttpServletRequest request,Model model) {
		SysUser user1 = (SysUser) request.getSession().getAttribute("userInfo");
		Long orgid = userService.load_first_orgid(user1);
		ArainResult result = userService.load_01(sysUser);
		List<SysRole> sysRoles = new ArrayList<>();
		JSONObject data = (JSONObject) result.getData();
		Object object = data.get("sysUser");
		
		SysUser user = JsonUtils.jsonToPojo(object.toString(), SysUser.class);
		Object object2 = data.get("sysRole");
		List<SysUserRoleKey> roleKey = JsonUtils.jsonToList(object2.toString(), SysUserRoleKey.class);
		for (SysUserRoleKey sysUserRoleKey : roleKey) {
			SysRole sysRole = new SysRole();
			sysRole.setId(sysUserRoleKey.getRoleId());
			ArainResult arainResult = sysRoleService.load_01(sysRole);
			SysRole role = (SysRole) arainResult.getData();
			sysRoles.add(role);
		}
		
		ArainResult list = sysRoleService.load_list(user1);
		List<SysRole> allRole = (List<SysRole>) list.getData();
		
		List<RoleResult> rolerList = new ArrayList<>();
		for (SysRole sysRole : allRole) {
			RoleResult roleResult = new RoleResult();
			roleResult.setName(sysRole.getName());
			roleResult.setId(sysRole.getId());
			rolerList.add(roleResult);
		}
		
		for (int i = 0; i < rolerList.size(); i++) {
			in:for (int j = 0; j < sysRoles.size(); j++) {
				if (rolerList.get(i).getId().toString().equals(sysRoles.get(j).getId().toString())) {
					rolerList.get(i).setChecked("checked");
					break in;
				} 
			}
			
		}
		model.addAttribute("orgid", orgid);
		model.addAttribute("roles", rolerList);
		model.addAttribute("sysUser",user);
		return "system/user/add_02";
	}
	
	
	@RequestMapping(value="load_combogrid",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_combogrid(int page, int rows, String sort, String order,@RequestParam(value="q",required=false) String q,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = userService.load_combogrid(page, rows, sort, order, q, user);
		return result.getData().toString();
	}
}
