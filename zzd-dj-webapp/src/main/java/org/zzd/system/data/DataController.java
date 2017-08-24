package org.zzd.system.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.pojo.AMGrid;
import org.zzd.common.pojo.ColumnsPojo;
import org.zzd.common.util.ArainResult;
/**
 * 
* <p>Title:DataController </p>
* @author Arain
* @date2017年8月1日
 */
@Controller
@RequestMapping("system/data")
public class DataController {
	@Autowired
	private DataService dataService;
	
	@RequestMapping("backup")
	@ResponseBody
	public ArainResult backup() {
		DataPojo pojo = new DataPojo();
		try {
			ArainResult result = dataService.exportDatabaseTool(pojo.getHostIP(), pojo.getUserName(), pojo.getPassword(), pojo.getSavePath(), pojo.getFileName(), pojo.getDatabaseName());
			return result;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return ArainResult.build(400, "信息错误");
	}
	
	@RequestMapping("list_01")
	public String load_list(Model model) {
		List<ColumnsPojo> columns = new ArrayList<>();
		AMGrid grid = new AMGrid();
		grid.setUrl("/system/data/load_datagrid.do");
		ColumnsPojo pojo;
		pojo = new ColumnsPojo("UserName", "数据库已知的用户");
		columns.add(pojo);
		pojo = new ColumnsPojo("URL", "数据库URL");
		columns.add(pojo);
		pojo = new ColumnsPojo("ProductName", "数据库的产品名称");
		columns.add(pojo);
		pojo = new ColumnsPojo("ProductVersion", "数据库的版本");
		columns.add(pojo);
		pojo = new ColumnsPojo("Version", "驱动程序的版");
		columns.add(pojo);
		pojo = new ColumnsPojo("tableName", "数据库名");
		columns.add(pojo);
		grid.setColumns(columns.toString());
		
		model.addAttribute("dataGrid", grid.toString());
		return "system/data/list_01";
	}
	
	@RequestMapping(value="load_datagrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid() throws Exception {
		ArainResult result = dataService.load_mysql();
		return result.getData().toString();
	}
}
