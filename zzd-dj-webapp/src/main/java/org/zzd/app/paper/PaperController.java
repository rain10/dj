package org.zzd.app.paper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.pojo.AMGrid;
import org.zzd.common.pojo.ColumnsPojo;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.ExaminationPaper;
import org.zzd.pojo.SysUser;

/**
 * 
 * <p>
 * Title:PaperController
 * </p>
 * 
 * @author Arain
 * @date2017年8月9日
 */
@Controller
@RequestMapping("app/paper")
public class PaperController {
	@Autowired
	private PaperService paperService;

	@RequestMapping("list_01")
	public String list_01(Model model) {
		List<ColumnsPojo> columnsPojos = new ArrayList<>();

		AMGrid grid = new AMGrid();
		grid.setUrl("app/paper/loadgrid.do");

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
//		pojo = new ColumnsPojo("ing_", "是否开始");
//		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("enabled_", "是否可用");
		columnsPojos.add(pojo);

		grid.setColumns(columnsPojos.toString());

		model.addAttribute("dataGrid", grid);

		return "app/paper/list_01";
	}

	@RequestMapping(value = "loadgrid.do", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(int page, int rows, String sort, String order, String title,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = paperService.load_grid(page, rows, sort, order, title, user);
		return result.getData().toString();
	}

	@RequestMapping("add_01")
	public String add_01(Model model) {
		return "app/paper/add_01";
	}
	
	@RequestMapping("save.do")
	@ResponseBody
	public ArainResult save_01(ExaminationPaper paper ,String questions,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		paper.setManager(user.getUsername()+"||"+user.getRealname());
		paper.setManagerTime(new Date());
		paper.setOrgid(user.getOrgid());
		ArainResult result = paperService.save_01(paper,questions);
		return result;
		
	}
	
	@RequestMapping("edit_01")
	public String edit_01(Model model,ExaminationPaper paper) {
		ArainResult result = paperService.edit_01(paper);
		ExaminationPaper data = (ExaminationPaper) result.getData();
		ArainResult quesyion_id = paperService.load_quesyion_id(data);
		model.addAttribute("questionids", quesyion_id.getData());
		model.addAttribute("paper",data);
		return "app/paper/add_01";
	}
	
	@RequestMapping("save_01.do")
	@ResponseBody
	public ArainResult save_suiji(ExaminationPaper paper ,Integer count,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		paper.setManager(user.getUsername()+"||"+user.getRealname());
		paper.setManagerTime(new Date());
		paper.setOrgid(user.getOrgid());
		ArainResult result = paperService.save_suiji(paper,count);
		return result;
		
	}
	
	@RequestMapping(value="load_combogrid", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String load_combogrid(int page, int rows, String sort, String order,@RequestParam(value="q",required=false) String q,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = paperService.load_combogrid(page, rows, q,user);
		return result.getData().toString();
		
	}
}
