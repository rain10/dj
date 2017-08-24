package org.zzd.system.log;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysLog;
import org.zzd.pojo.SysUser;

public interface SysLogService {
	public ArainResult load_list(String username,String sort,Integer page,Integer rows);
	
	public ArainResult save_01(SysUser user,SysLog log);
	
	public ArainResult load_safe(SysUser user);
}
