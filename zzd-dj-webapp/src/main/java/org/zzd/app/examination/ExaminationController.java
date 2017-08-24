package org.zzd.app.examination;

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
import org.zzd.pojo.ExaminationAnswer;
import org.zzd.pojo.ExaminationQuestions;
import org.zzd.pojo.SysUser;
/**
 * 
* <p>Title:ExaminationController </p>
* @author Arain
* @date2017年8月7日
 */
@Controller
@RequestMapping("app/examination")
public class ExaminationController {
	@Autowired
	private ExaminationService examinationService;
	@RequestMapping("list_01")
	public String list_01(Model model) {
		List<ColumnsPojo> columnsPojos = new ArrayList<>();
		
		AMGrid grid = new AMGrid();
		grid.setUrl("app/examination/loadgrid.do");
		
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
		pojo = new ColumnsPojo("enabled_", "是否可用");
		columnsPojos.add(pojo);
		
		grid.setColumns(columnsPojos.toString());
		
		model.addAttribute("dataGrid", grid);
		
		return "app/examination/list_01";
	}
	
	@RequestMapping(value="loadgrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(int page, int rows, String sort,String order,String title,String type,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = examinationService.load_grid(page, rows, sort, order, title,type,user);
		return result.getData().toString();
	}
	
	
	
	@RequestMapping("add_01")
	public String add_01() {
		return "app/examination/add_01";
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public ArainResult save(ExaminationQuestions questions,String answerJson,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		questions.setManager(user.getUsername()+"||"+user.getRealname());
		questions.setManagerTime(new Date());
		questions.setOrgid(user.getOrgid());
		ArainResult result = examinationService.save_01(questions, answerJson);
		return result;
	}
	
	@RequestMapping("edit_01")
	public String edit_01(ExaminationQuestions questions,Model model) {
		ArainResult result = examinationService.edit_01(questions);
		model.addAttribute("question", result.getData());
		return "app/examination/add_01";
	}
	
	@RequestMapping(value="load_edit_grid",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_edit_grid(ExaminationAnswer answer) {
		ArainResult result = examinationService.load_edit_grid(answer);
		return result.getData().toString();
		
	}
	
	@RequestMapping(value="paper_loadgrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String paper_loadgrid(int page, int rows, String sort,String order,String title,String type,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = examinationService.paper_load_grid(page, rows, sort, order, title,type,user);
		return result.getData().toString();
	}
}
