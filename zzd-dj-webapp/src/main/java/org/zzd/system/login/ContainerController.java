package org.zzd.system.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zzd.common.pojo.MenuPojo;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysResource;
import org.zzd.pojo.SysUser;
import org.zzd.system.menu.MenuService;
import org.zzd.system.quick.QuickService;

@Controller
public class ContainerController {
	@Autowired
	private MenuService menuSerice;
//	@Autowired
//	private QuickService quickService;
	@SuppressWarnings("unchecked")
	@RequestMapping("container")
	public String container(Model model,HttpServletRequest request) {
		SysUser sysUser = (SysUser) request.getSession().getAttribute("userInfo");
		List<MenuPojo> reMenuPojos = new ArrayList<>();
		ArainResult result = menuSerice.load_menu(sysUser);
		List<SysResource> data = (List<SysResource>) result.getData();
		for (SysResource sysResource : data) {
			MenuPojo menuPojo = new MenuPojo();
			menuPojo.setId(sysResource.getId());
			menuPojo.setName(sysResource.getName());
			menuPojo.setPid(sysResource.getPid());
			menuPojo.setIcon(sysResource.getIcon());
			menuPojo.setTarget(sysResource.getTarget());
			ArainResult child = menuSerice.load_child(sysResource.getId(),sysUser);
			List<SysResource> data2 = (List<SysResource>) child.getData();
			menuPojo.setChildren(data2);
			reMenuPojos.add(menuPojo);
		}
		
//		List<SysResource> list = quickService.load_list(sysUser);
//		if(list!=null && list.size()>0) {
//			model.addAttribute("quick", list);
//		}
		model.addAttribute("menu",reMenuPojos);
		return "system/container";
	}
}
