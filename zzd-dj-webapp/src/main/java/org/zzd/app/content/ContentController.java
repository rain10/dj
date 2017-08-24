package org.zzd.app.content;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.pojo.AMGrid;
import org.zzd.common.pojo.ColumnsPojo;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.pojo.Content;
import org.zzd.pojo.ContentPropelling;
import org.zzd.pojo.ContentPropellingKey;
import org.zzd.pojo.SysUser;
import org.zzd.system.aspect.annotation.SystemControllerLog;
import org.zzd.system.department.SysDepartmentService;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * <p>
 * Title:ContentController
 * </p>
 * 
 * @author Arain
 * @date2017年8月3日
 */
@Controller
@RequestMapping("app/content")
public class ContentController {
	@Autowired
	private ContentService contentService;
	@Autowired
	private SysDepartmentService sysDepartmentService;
	@RequestMapping("list_01")
	public String list_01(Model model,Integer type) {
		List<ColumnsPojo> columns = new ArrayList<>();
		AMGrid grid = new AMGrid();
		grid.setUrl("app/content/loadgrid.do?type="+type);

		ColumnsPojo pojo;
		pojo = new ColumnsPojo("ID_", "id");
		pojo.setHidden(true);
		pojo = new ColumnsPojo("title_", "标题");
		columns.add(pojo);
		pojo = new ColumnsPojo("manager_", "经办人");
		columns.add(pojo);
		pojo = new ColumnsPojo("maneger_time_", "经办时间");
		columns.add(pojo);
		pojo = new ColumnsPojo("enabled_", "是否可用");
		columns.add(pojo);

		grid.setColumns(columns.toString());
		
		
		model.addAttribute("search", DictUtil.load_dict(type.toString(),"search").getDispaly());
		model.addAttribute("content_title", DictUtil.load_dict(type.toString(),"content_title").getDispaly());
		model.addAttribute("grid", DictUtil.load_dict(type.toString(),"grid").getDispaly());
		model.addAttribute("dataGrid", grid.toString());
		model.addAttribute("contentType",type);

		return "app/content/list_01";
	}
	
	@RequestMapping(value="loadgrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(int page, int rows, String sort,String order,String title,Integer type,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = contentService.load_grid(page, rows, sort, order, title,type,user);
		return result.getData().toString();
	}
	
	@RequestMapping("add_01")
	public String add_01(Model model,Integer type) {
		model.addAttribute("contentType",type);
		return "app/content/add_01";
	}
	
	@RequestMapping("edit_01")
	public String edit_01(Content content,Model model) {
		ArainResult result = contentService.load_01(content);
		content = (Content) result.getData();
		model.addAttribute("news", content);
		return "app/content/add_01";
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public ArainResult save_01(Content content,String[] imageId,HttpServletRequest request,@RequestParam(value="newscontent",required=false)String newscontent) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		content.setManager(user.getUsername()+"||"+user.getRealname());
		content.setManegerTime(new Date());
		content.setContent(newscontent);
		content.setOrgid(user.getOrgid());
		if(StringUtils.isBlank(content.getOther())) {
			String dept_name = sysDepartmentService.load_dept_name(user);
			content.setOther(dept_name);
		}
		ArainResult result = contentService.save_01(content,imageId);
		return result;
	}
	
	@RequestMapping("text")
	@ResponseBody
	public ArainResult text() {
		JSONArray array = new JSONArray();
		JSONObject object= new JSONObject();
		object.put("id", 1);
		object.put("url", "/admin/img/1501824796518002.jpg");
		array.add(object);
		JSONObject object1= new JSONObject();
		object1.put("id", 1);
		object1.put("url", "/admin/img/1501824796518002.jpg");
		array.add(object1);
		JSONObject object2= new JSONObject();
		object2.put("id", 1);
		object2.put("url", "/admin/img/1501824796518002.jpg");
		array.add(object2);
		
		return ArainResult.ok(array);
	}
	
	@RequestMapping("send_01")
	public String send_01(Model model,Content content) {
		ArainResult result = contentService.load_01(content);
		content = (Content) result.getData();
		model.addAttribute("content", content);
		return "app/content/send_01";
	}
	
	
	@RequestMapping("send.do")
	@ResponseBody
	public ArainResult send_send(String propellingTime,ContentPropellingKey key) {
		ArainResult result = contentService.save_send(propellingTime, key);
		return result;
	}
	
	@RequestMapping("load_send.do")
	public String load_send() {
		return "app/content/rec_01";
	}
	
	@RequestMapping(value="load_send_data.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_send_data(HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = contentService.load_send(user);
		return result.getData().toString();
	}
	
	@RequestMapping("updata")
	@ResponseBody
	public ArainResult updata_01(ContentPropellingKey key,Integer action,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = contentService.update_01(user,key, action);
		return result;
	}
	
	@RequestMapping("see_content")
	public String see_content(ContentPropellingKey key,HttpServletRequest request,Model model) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = contentService.load_see(user, key);
		model.addAttribute("content", result.getData());
		return "app/content/view_01";
	}
}
