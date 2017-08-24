package org.zzd.system.log;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.IDUtil;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.SysLogMapper;
import org.zzd.pojo.SysLog;
import org.zzd.pojo.SysLogExample;
import org.zzd.pojo.SysLogExample.Criteria;
import org.zzd.pojo.SysUser;

import com.github.pagehelper.PageHelper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
* <p>Title:LogServiceImpl </p>
* @author Arain
* @date2017年5月31日
 */
@Service
public class SysLogServiceImpl implements SysLogService{
	@Autowired
	private SysLogMapper sysLogMapper;

	@Override
	public ArainResult load_list(String username,String sort,Integer page,Integer rows) {
		JSONObject out = new JSONObject();
		JSONArray array = new JSONArray();
		SysLogExample example = new SysLogExample();
		example.setOrderByClause("LOGIN_TIME_ desc");
		Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(username)) {
			criteria.andUsernameLike("%"+username+"%");
		}
		if(StringUtils.isNotBlank(sort)) {
			example.setOrderByClause(sort);
		}
		
		PageHelper.startPage(page, rows);
		List<SysLog> list = sysLogMapper.selectByExample(example);
		int count = sysLogMapper.countByExample(example);
		for (SysLog sysLog : list) {
			JSONObject object = new JSONObject();
			object.accumulate("ID_", sysLog.getId());
			object.accumulate("USERNAME_", sysLog.getUsername());
			object.accumulate("MAC_", sysLog.getMac());
			object.accumulate("LOGIN_TIME_", TimeUtil.format(sysLog.getLoginTime()));
			object.accumulate("IP_", sysLog.getIp());
			
			array.add(object);
		}
		out.accumulate("total",count);
		out.accumulate("rows",array);
		
		return ArainResult.ok(out.toString());
	}

	@Override
	public ArainResult save_01(SysUser user,SysLog log) {
		log.setId(Long.valueOf(IDUtil.genId()));
		log.setLoginTime(new Date());
		if(user==null) {
			log.setUsername("非法用户");
			log.setUserId((long) 0);
		} else {
			log.setUsername(user.getUsername());
			log.setUserId(user.getId());
		}
		
		sysLogMapper.insert(log);
		return ArainResult.ok(log);
	}

	@Override
	public ArainResult load_safe(SysUser user) {
		SysLogExample example = new SysLogExample();
		example.createCriteria().andUserIdEqualTo(user.getId());
		example.setOrderByClause("LOGIN_TIME_  desc");
		List<SysLog> list = sysLogMapper.selectByExample(example);
		if(list.size()<2) {
			return ArainResult.ok(list.get(0));
		}
		return ArainResult.ok(list.get(1));
	}
}
