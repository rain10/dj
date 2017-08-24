package org.zzd.system.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 
* <p>Title:LogController </p>
* @author Arain
* @date2017年5月31日
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.util.ArainResult;
@Controller
@RequestMapping("system/log")
public class SysLogController {
	@Autowired
	private SysLogService logService;
	
	
	@RequestMapping("list_01")
	public String list_01() {
		return "system/log/list_01";
	}
	
	
	@RequestMapping(value="load_datagrid.do",produces="text/json;charset=UTF-8")
	@ResponseBody
	public String load_grid(String username,String sort,@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows) {
		ArainResult result = logService.load_list(username,sort,page,rows);
		String array = (String) result.getData();
		return array;
	}

}
