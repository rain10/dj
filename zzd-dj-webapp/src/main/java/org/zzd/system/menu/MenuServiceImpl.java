package org.zzd.system.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.mapper.SysResourceMapper;
import org.zzd.mapper.SysRoleResourceMapper;
import org.zzd.mapper.SysUserMapper;
import org.zzd.mapper.SysUserRoleMapper;
import org.zzd.pojo.SysResource;
import org.zzd.pojo.SysResourceExample;
import org.zzd.pojo.SysRoleResource;
import org.zzd.pojo.SysRoleResourceExample;
import org.zzd.pojo.SysRoleResourceExample.Criteria;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.SysUserRoleExample;
import org.zzd.pojo.SysUserRoleKey;
/**
 * 
* <p>Title:MenuServiceImpl </p>
* @author Arain
* @date2017年5月18日
 */
@Service
public class MenuServiceImpl implements MenuService{
	@Autowired
	private SysResourceMapper sysResourceMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleResourceMapper sysRoleResourceMapper;
	@SuppressWarnings("unchecked")
	@Override
	public ArainResult load_menu(SysUser user) {
		List<SysResource> sort = new ArrayList<>();
		Set<SysResource> resList = new HashSet<SysResource>();
		SysUser sysUser = sysUserMapper.selectByPrimaryKey((long) user.getId());
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		org.zzd.pojo.SysUserRoleExample.Criteria criteria = sysUserRoleExample.createCriteria();
		criteria.andUserIdEqualTo(sysUser.getId());
		List<SysUserRoleKey> sysUserRoleKeys = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		
		for (SysUserRoleKey sysUserRoleKey : sysUserRoleKeys) {
			Long roleId = sysUserRoleKey.getRoleId();
			 
			SysRoleResourceExample example = new SysRoleResourceExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andRoleIdEqualTo(roleId);
			List<SysRoleResource> list = sysRoleResourceMapper.selectByExample(example);
			
			for (SysRoleResource sysRoleResource : list) {
				Long resourceId = sysRoleResource.getResourceId();
				SysResourceExample resourceExample = new SysResourceExample();
				resourceExample.setDistinct(true);
				resourceExample.setOrderByClause("sort_");
				org.zzd.pojo.SysResourceExample.Criteria createCriteria2 = resourceExample.createCriteria();
				createCriteria2.andEnabledEqualTo((short) 1);
				createCriteria2.andPidEqualTo((long) 0);
				createCriteria2.andIdEqualTo(resourceId);
				
				List<SysResource> list2 = sysResourceMapper.selectByExample(resourceExample);
				for (SysResource sysResource : list2) {
					resList.add(sysResource);
				}
			}
		}
		
		for (SysResource sysUserRole : resList) {
			sort.add(sysUserRole);
		}
		 Collections.sort(sort);
		 
		return ArainResult.ok(sort);
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArainResult load_child(long pid,SysUser sysUser) {
		Set<SysResource> resList = new HashSet<SysResource>();
		List<SysResource>  sort = new ArrayList<>();
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		org.zzd.pojo.SysUserRoleExample.Criteria criteria = sysUserRoleExample.createCriteria();
		criteria.andUserIdEqualTo(sysUser.getId());
		List<SysUserRoleKey> sysUserRoleKeys = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		for (SysUserRoleKey sysUserRoleKey : sysUserRoleKeys) {
			Long roleId = sysUserRoleKey.getRoleId();
			SysRoleResourceExample example = new SysRoleResourceExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andRoleIdEqualTo(roleId);
			List<SysRoleResource> list = sysRoleResourceMapper.selectByExample(example);
			for (SysRoleResource sysRoleResource : list) {
				Long resourceId = sysRoleResource.getResourceId();
				SysResourceExample resourceExample = new SysResourceExample();
				resourceExample.setDistinct(true);
				resourceExample.setOrderByClause("sort_");
				org.zzd.pojo.SysResourceExample.Criteria createCriteria2 = resourceExample.createCriteria();
				createCriteria2.andEnabledEqualTo((short) 1);
				createCriteria2.andPidEqualTo(pid);
				createCriteria2.andIdEqualTo(resourceId);
				
				List<SysResource> list2 = sysResourceMapper.selectByExample(resourceExample);
				for (SysResource sysResource : list2) {
					resList.add(sysResource);
				}
			}
		}
		for (SysResource sysUserRole : resList) {
			sort.add(sysUserRole);
		}
		
		Collections.sort(sort);
		return ArainResult.ok(sort);
	}

}
