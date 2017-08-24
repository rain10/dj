package org.zzd.system.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 
* <p>Title:MenuController </p>
* @author Arain
* @date2017年5月18日
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysUser;
@Controller
@RequestMapping("system")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("menu/load_child.do")
	@ResponseBody
	public ArainResult load_menu(long pid,HttpServletRequest request){
		SysUser sysUser = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = menuService.load_child(pid,sysUser);
		
		System.out.println(result.getData());
		return result;
	}
}
