package org.zzd.system.handle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.pojo.AMGrid;
import org.zzd.common.pojo.ColumnsPojo;
import org.zzd.common.util.ArainResult;

/**
 * 
* <p>Title:SysLogHandleController </p>
* @author Arain
* @date2017年6月28日
 */

@Controller
@RequestMapping("system/loghandle")
public class SysLogHandleController {
	@Autowired
	private SysLogHandleService sysLogHandleService;
	
	@RequestMapping("list_01")
	public String load_list(Model model) {
		List<ColumnsPojo> columns = new ArrayList<>();
		AMGrid grid = new AMGrid();
		grid.setUrl("/system/loghandle/load_datagrid.do");
		ColumnsPojo pojo;
		
		pojo = new ColumnsPojo("LOG_ID", "id");
		pojo.setHidden(true);
		columns.add(pojo);
		pojo = new ColumnsPojo("LOG_USER", "访问用户");
		columns.add(pojo);
		pojo = new ColumnsPojo("LOG_URL", "访问路径");
		columns.add(pojo);
		pojo = new ColumnsPojo("LOG_DATA", "访问参数");
		columns.add(pojo);
		pojo = new ColumnsPojo("LOG_SUCCESS", "访问状态");
		columns.add(pojo);
		pojo = new ColumnsPojo("LOG_EXCEPTION", "异常情况");
		columns.add(pojo);
		pojo = new ColumnsPojo("LOG_IP", "访问IP");
		columns.add(pojo);
		pojo = new ColumnsPojo("LOG_TIME", "访问时间");
		columns.add(pojo);
		
		grid.setColumns(columns.toString());
		model.addAttribute("dataGrid", grid);
		
		return "system/loghandle/list_01";
	}
	
	@RequestMapping(value="load_datagrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(String username,String sort,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows) {
		ArainResult result = sysLogHandleService.load_list(username,sort,page,rows);
		String array = (String) result.getData();
		return array;
	}
}
