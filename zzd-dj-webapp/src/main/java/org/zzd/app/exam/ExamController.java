package org.zzd.app.exam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.app.ehcache.EhcacheService;
import org.zzd.common.pojo.AMGrid;
import org.zzd.common.pojo.ColumnsPojo;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.TimeUtil;
import org.zzd.pojo.Examination;
import org.zzd.pojo.ExaminationWithBLOBs;
import org.zzd.pojo.SysUser;

/**
 * 
 * <p>
 * Title:ExamController
 * </p>
 * 
 * @author Arain
 * @date2017年8月11日
 */
@Controller
@RequestMapping("app/exam")
public class ExamController {
	@Autowired
	private ExamService examService;
	@Autowired
	private EhcacheService ehcacheService;
	@RequestMapping("list_01")
	public String list_01(Model model) {
		List<ColumnsPojo> columnsPojos = new ArrayList<>();

		AMGrid grid = new AMGrid();
		grid.setUrl("app/exam/loadgrid.do");

		ColumnsPojo pojo;
		pojo = new ColumnsPojo("ID_", "id");
		pojo.setHidden(true);
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("title_", "标题");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("start_time_", "开始时间");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("end_time_", "结束时间");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("manager_", "经办人");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("maneger_time_", "经办时间");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("type_", "考试类型");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("ing_", "进行状态");
		columnsPojos.add(pojo);
		pojo = new ColumnsPojo("enabled_", "是否有效");
		columnsPojos.add(pojo);

		grid.setColumns(columnsPojos.toString());

		model.addAttribute("dataGrid", grid);

		return "app/exam/list_01";
	}

	@RequestMapping(value = "loadgrid.do", produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(int page, int rows, String sort, String order, String title, Integer type,HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = examService.load_grid(page, rows, sort, order, title, type,user);
		return result.getData().toString();
	}

	@RequestMapping("add_01")
	public String add_01() {
		return "app/exam/add_01";
	}

	@RequestMapping(value = "save.do")
	@ResponseBody
	public ArainResult save(ExaminationWithBLOBs examination, String start, String end, HttpServletRequest request, Long time) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		examination.setManager(user.getUsername() + "||" + user.getRealname());
		examination.setManagerTime(new Date());
		examination.setStartTime(TimeUtil.parse(start));
		examination.setEndTime(TimeUtil.parse(end));
		examination.setOrgid(user.getOrgid());
		// examination.setIngTime(time);
		ArainResult result = examService.save_01(examination);
		if (result.getStatus() == 200) {
			ehcacheService.load_list();
		}
		return result;
	}

	@RequestMapping("edit_01")
	public String edit_01(Model model, ExaminationWithBLOBs examination) {
		ArainResult result = examService.load_01(examination);
		Examination data = (Examination) result.getData();
		model.addAttribute("starttime", TimeUtil.format(data.getStartTime(), TimeUtil.FORMAT_LONG));
		model.addAttribute("endtime", TimeUtil.format(data.getEndTime(), TimeUtil.FORMAT_LONG));
		model.addAttribute("exam", result.getData());
		return "app/exam/add_01";
	}
}
