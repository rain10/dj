package org.zzd.app.examinationtype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.pojo.AMGrid;
import org.zzd.common.pojo.ColumnsPojo;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.ExaminationQuestions;
import org.zzd.pojo.ExaminationType;
import org.zzd.pojo.SysUser;

/**
 * 
* <p>Title:ExaminationTypeController </p>
* @author Arain
* @date2017年8月8日
 */
@Controller
@RequestMapping("app/type")
public class ExaminationTypeController {
	@Autowired
	private ExaminationTypeService examinationTypeService;
	@RequestMapping("list_01")
	public String list_01(Model model) {
		List<ColumnsPojo> columnsPojos = new ArrayList<>();
		
		AMGrid grid = new AMGrid();
		grid.setUrl("app/type/loadgrid.do");
		
		ColumnsPojo pojo;
		pojo = new ColumnsPojo("ID_", "id");
		pojo.setHidden(true);
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("title_", "标题");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("manager_", "经办人");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("manager_time_", "经办时间");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("enabled", "是否可用");
		columnsPojos.add(pojo);
		
		grid.setColumns(columnsPojos.toString());
		
		model.addAttribute("dataGrid", grid);
		
		return "app/type/list_01";
	}
	
	@RequestMapping(value="loadgrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(int page, int rows, String sort,String order,String title,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = examinationTypeService.load_grid(page, rows, sort, order, title,user);
		return result.getData().toString();
	}
	
	@RequestMapping("add_01")
	public String add_01() {
		return "app/type/add_01";
	}
	
	@RequestMapping("edit_01")
	public String edit_01(Model model,ExaminationType type) {
		ArainResult result = examinationTypeService.edit_01(type);
		model.addAttribute("type", result.getData());
		return "app/type/add_01";
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public ArainResult save(ExaminationType type,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		type.setManager(user.getUsername()+"||"+user.getRealname());
		type.setManagerTime(new Date());
		type.setOrgid(user.getOrgid());
		ArainResult result =examinationTypeService.save_01(type);
		return result;
	}
	
	@RequestMapping(value="load_type",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_type(ExaminationQuestions type,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = examinationTypeService.load_type(type,user);
		return result.getData().toString();
	}
}
