package org.zzd.system.user;

import org.springframework.web.bind.annotation.RequestParam;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysUser;

public interface SysUserService {
	/**
	 *  保存功能
	 * @param dto
	 * @return
	 */
	public ArainResult save_01(SysUser SysUser,String [] roles);
	
	/**
	 * 修改页面加载回显数据
	 * @param sysResourceDto
	 */
	public ArainResult load_01(SysUser SysUser);
	
	/**
	 * 
	 * @param user
	 * @param valiDate
	 * @return
	 */
	public ArainResult load_login(SysUser user);
	
	
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
	public ArainResult load_list(int page, int rows, String sort,String order,String username,Short enable,String realname,SysUser user,Short type);
	
	
	public ArainResult load_shiro(String url,SysUser sysUser);
	
	public ArainResult save_password_edit(String oldpassword,String newpassword,SysUser user);
	
	public void save_image(SysUser user,String url);
	
	public Long load_first_orgid();
	public Long load_first_orgid(SysUser user);
	
	public ArainResult load_combogrid(int page, int rows, String sort, String order,String q,SysUser user);
}
