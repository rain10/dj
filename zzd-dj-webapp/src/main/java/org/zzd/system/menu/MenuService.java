package org.zzd.system.menu;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysUser;

public interface MenuService {
	ArainResult load_menu(SysUser user);
	ArainResult load_child(long pid,SysUser sysUser);
}
