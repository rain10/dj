package org.zzd.system.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.pojo.MenuPojo;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.JsonUtils;
import org.zzd.pojo.SysResource;
import org.zzd.pojo.SysRole;
import org.zzd.pojo.SysUser;
/**
 * 
* <p>Title:SysResourceController </p>
* @author Arain
* @date2017年5月18日
 */
@Controller
@PropertySource(value = "classpath:resources.properties",encoding = "utf-8")
@RequestMapping("system/resource")
public class SysResourceController {
	@Autowired
	private SysResourceService SysResourceService;
	@Value("${MENU}")
	private String menu;
	@Value("${MODULE}")
	private String module;
	

	@RequestMapping("list_01")
	public String load_list(HttpServletRequest request,Model model) {
		return "system/resource/list_01";
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="load_datagrid.do", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(HttpServletRequest request,HttpServletResponse response) {
		SysUser sysUser = (SysUser) request.getSession().getAttribute("userInfo");
		List<MenuPojo> reMenuPojos = new ArrayList<>();
		ArainResult result = SysResourceService.load_menu(sysUser);
		List<SysResource> data = (List<SysResource>) result.getData();
		for (SysResource sysResource : data) {
			MenuPojo menuPojo = new MenuPojo();
			menuPojo.setId(sysResource.getId());
			menuPojo.setName(sysResource.getName());
			menuPojo.setPid(sysResource.getPid());
			menuPojo.setEnabled(DictUtil.load_dict(sysResource.getEnabled().toString(), "ENABLED_").getDispaly());
			menuPojo.setSort(sysResource.getSort());
			menuPojo.setTarget(sysResource.getTarget());
			menuPojo.setType(menu);
			ArainResult arainResult = SysResourceService.load_child(sysResource.getId(),sysUser);
			List<SysResource> data2 = (List<SysResource>) arainResult.getData();
			List<MenuPojo> child = new ArrayList<>();
			for (SysResource sysResource2 : data2) {
				MenuPojo menuPojo2 = new MenuPojo();
				menuPojo2.setId(sysResource2.getId());
				menuPojo2.setName(sysResource2.getName());
				menuPojo2.setPid(sysResource2.getPid());
				menuPojo2.setEnabled(DictUtil.load_dict(sysResource2.getEnabled().toString(), "ENABLED_").getDispaly());
				menuPojo2.setSort(sysResource2.getSort());
				menuPojo2.setTarget(sysResource2.getTarget());
				menuPojo2.setType(module);
				child.add(menuPojo2);
			}
			menuPojo.setChildren(child);
			reMenuPojos.add(menuPojo);
		}
		String string = JsonUtils.objectToJson(reMenuPojos);
		return string;
	}
	
	@RequestMapping("add_01")
	public String load_add(Model model) {
		return "system/resource/add_01";
	}
	
	@RequestMapping(value="load_tree.do", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String load_tree(HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = SysResourceService.load_tree(user);
		String tree = (String) result.getData();
		return tree;
	}
	
	@RequestMapping(value="load_tree_role.do", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String load_tree_role(SysRole role,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = SysResourceService.load_tree(role,user);
		String tree = (String) result.getData();
		return tree;
	}
	
	
	@RequestMapping(value="save.do")
	@ResponseBody
	public ArainResult save_01(SysResource resource,String resourceJsons) {
		List<String> icons = SysResourceService.load_icons();
		Random rd=new Random();
		int i = rd.nextInt(icons.size());
		resource.setIcon(icons.get(i));
//		SysResource sysResource = JsonUtils.jsonToPojo(resourceJsons, SysResource.class);
		ArainResult result = SysResourceService.save_01(resource, resourceJsons);
		return result;
	}
	
	@RequestMapping("edit_01")
	public String load_edit(SysResource resource,Model model) {
		ArainResult result = SysResourceService.load_01(resource);
		SysResource data = (SysResource) result.getData();
		model.addAttribute("sysResource",data);
		return "system/resource/add_01";
	}
	
	@RequestMapping(value="load_edit_grid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_edit_grid(SysResource resource) {
		ArainResult result = SysResourceService.load_edit_grid(resource);
		String data = (String) result.getData();
		return data;
	}
}
