package org.zzd.system.role;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysRole;
import org.zzd.pojo.SysUser;

public interface SysRoleService {
	/**
	 *  保存功能
	 * @param dto
	 * @return
	 */
	public ArainResult save_01(SysRole sysRole,String resourceIds,SysUser sysUser);
	
	/**
	 * 修改页面加载回显数据
	 * @param sysResourceDto
	 */
	public ArainResult load_01(SysRole sysRole);
	
	/**
	 * 加载tree
	 * @return
	 */
	public ArainResult loadResource(String roleId);
	
	public ArainResult loadResource(String roleId, String userType, String userId);
	
	/**
	 * 加载机构树，当前及以下
	 * @param orgid 为空时加载所有机构
	 * @return
	 */
	public ArainResult loadOrgTree(String orgid);
	
	/**
	 * 
	 * @return
	 */
	public ArainResult load_list(SysUser user);
	
	public ArainResult load_list(int page,int rows, String sort,String order,String name,Short enable,SysUser sysUser);
	
}
