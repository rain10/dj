package org.zzd.system.department;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysGroup;
import org.zzd.pojo.SysUser;

/**
 * 
* <p>Title:SysDepartmentController </p>
* @author Arain
* @date2017年8月14日
 */
@Controller
@RequestMapping("system/department")
public class SysDepartmentController {
	@Autowired
	private SysDepartmentService sysDepartmentService;
	@RequestMapping("list_01")
	public String list_01(Model model,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = sysDepartmentService.load_orgid(user);
		model.addAttribute("orgid",user.getOrgid());
		model.addAttribute("group", result.getData());
		return "system/department/list_01";
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public ArainResult save_01(Long oid,String dept,SysGroup group) {
		group.setOrgid(oid);
		ArainResult save_group = sysDepartmentService.save_group(group);
		if(save_group.getStatus()==200) {
			ArainResult result = sysDepartmentService.save_01(oid,dept);
			return result;
		}
		return save_group;
	}
	
	@RequestMapping(value="load_edit_grid",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_edit_grid(Long orgid) {
		ArainResult result = sysDepartmentService.load_orgid(orgid);
		return result.getData().toString();
	}
	
	@RequestMapping(value="load_01",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_01(HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = sysDepartmentService.load_01(user);
		return result.getData().toString();
	}
}
