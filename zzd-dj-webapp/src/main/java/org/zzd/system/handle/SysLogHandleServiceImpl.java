package org.zzd.system.handle;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.SysLogHandleMapper;
import org.zzd.pojo.SysLogHandle;
import org.zzd.pojo.SysLogHandleExample;
import org.zzd.pojo.SysLogHandleExample.Criteria;

import com.github.pagehelper.PageHelper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
* <p>Title:SysLogHandleServiceImpl </p>
* @author Arain
* @date2017年6月28日
 */

@Service
public class SysLogHandleServiceImpl implements SysLogHandleService{
	@Autowired
	private SysLogHandleMapper sysLogHandleMapper;

	@Override
	public ArainResult save_01(SysLogHandle sysLogHandle) {
		sysLogHandle.setLogTime(new Date());
		sysLogHandleMapper.insert(sysLogHandle);
		return ArainResult.ok();
	}

	@Override
	public ArainResult load_list(String username, String sort, Integer page, Integer rows) {
		JSONObject out = new JSONObject();
		JSONArray array = new JSONArray();
		SysLogHandleExample example = new SysLogHandleExample();
		example.setOrderByClause("LOG_TIME desc");
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(username)) {
			criteria.andLogUserLike("%"+username+"%");
		}
		if(StringUtils.isNotBlank(sort)) {
			example.setOrderByClause(sort);
		}
		
		PageHelper.startPage(page, rows);
		List<SysLogHandle> list = sysLogHandleMapper.selectByExample(example);
		int count = sysLogHandleMapper.countByExample(example);
		for (SysLogHandle sysLog : list) {
			com.alibaba.fastjson.JSONObject object = new com.alibaba.fastjson.JSONObject();
			object.put("LOG_ID", sysLog.getLogId());
			object.put("LOG_USER", sysLog.getLogUser());
			object.put("LOG_URL", sysLog.getLogUrl());
			object.put("LOG_DATA", "请求参数："+sysLog.getLogData().toString());
			object.put("LOG_SUCCESS",DictUtil.load_dict(sysLog.getLogSuccess(), "LOG_SUCCESS").getDispaly());
			object.put("LOG_EXCEPTION", sysLog.getLogException());
			object.put("LOG_IP", sysLog.getLogIp());
			object.put("LOG_TIME", TimeUtil.format(sysLog.getLogTime()));
			
			array.add(object);
		}
		out.accumulate("total",count);
		out.accumulate("rows",array);
		
		return ArainResult.ok(out.toString());
	}

}
