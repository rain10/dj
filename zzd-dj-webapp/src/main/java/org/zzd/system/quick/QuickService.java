package org.zzd.system.quick;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.SysUserQuickKey;

public interface QuickService {
	ArainResult save_01(SysUserQuickKey key,SysUser user);
	
	ArainResult load_01(SysUserQuickKey key,SysUser user);
	
	ArainResult load_list(SysUser user);
	
	ArainResult delete_01(SysUserQuickKey key,SysUser user);
}
