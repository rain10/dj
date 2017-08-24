package org.zzd.system.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysUser;
import org.zzd.system.user.SysUserService;

@Controller
@RequestMapping("personal/user")
public class PersonalController {
	@Autowired
	private SysUserService sysUserService;
	@Value("${DEFAULIMG}")
	private String img;
	
	@RequestMapping("info")
	public String info(HttpServletRequest request,Model model) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		model.addAttribute("personal", user);
		return "system/personal";
	}
	
	@RequestMapping("head")
	public String head(HttpServletRequest request,Model model) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		if(user!=null) {
			if(StringUtils.isBlank(user.getPrphone())) {
				user.setPropen(img);
			}
			model.addAttribute("sysUser", user);
		}
		
		return "system/head";
	}
	
	
	@RequestMapping("password.do")
	@ResponseBody
	public ArainResult password(String newpassword,String oldpassword,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = sysUserService.save_password_edit(oldpassword, newpassword, user);
		return result;
	}
}
