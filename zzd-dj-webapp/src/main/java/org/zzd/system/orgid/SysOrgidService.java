package org.zzd.system.orgid;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysOrganization;

public interface SysOrgidService {
	public String load_datagrid(Long city);
	public String load_map();
	public String load_tree();
	public ArainResult  save_01(SysOrganization sysOrganization);
	public ArainResult load_01(SysOrganization sysOrganization);
	
}
