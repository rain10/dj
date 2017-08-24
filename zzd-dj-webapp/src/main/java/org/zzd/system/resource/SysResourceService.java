package org.zzd.system.resource;

import java.util.List;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysResource;
import org.zzd.pojo.SysRole;
import org.zzd.pojo.SysUser;

public interface SysResourceService {
	/**
	 *  保存功能
	 * @param dto
	 * @return
	 */
	public ArainResult save_01(SysResource resource,String resourceJsons);
	
	/**
	 * 修改页面加载回显数据
	 * @param sysResourceDto
	 */
	public ArainResult load_01(SysResource resource);
	
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
	public ArainResult load_edit_grid(SysResource resource);
	
	/**
	 * 
	 * @return
	 */
	public ArainResult load_list();
	public ArainResult load_list(long pid);
	
	public ArainResult load_tree(SysUser sysUser);
	public ArainResult load_tree(SysRole role,SysUser sysUser);
	
	ArainResult load_menu(SysUser user);
	ArainResult load_child(long pid,SysUser sysUser);
	
	List<String> load_icons();
}
