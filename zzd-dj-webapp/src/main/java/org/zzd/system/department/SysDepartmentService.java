package org.zzd.system.department;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysGroup;
import org.zzd.pojo.SysUser;

public interface SysDepartmentService {
	ArainResult load_orgid(SysUser user);

	ArainResult save_01(Long id, String dept);
	
	ArainResult load_orgid(Long orgid);
	
	ArainResult load_01(SysUser user);
	
	String load_dept_name(SysUser user);
	
	ArainResult save_group(SysGroup group);
}
