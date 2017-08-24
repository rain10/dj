package org.zzd.system.handle;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysLogHandle;

public interface SysLogHandleService {
	ArainResult save_01(SysLogHandle sysLogHandle);

	ArainResult load_list(String username, String sort, Integer page, Integer rows);
}
