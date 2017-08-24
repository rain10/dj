package org.zzd.system.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.zzd.common.pojo.SysResourceIcons;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.IDUtil;
import org.zzd.mapper.SysResourceMapper;
import org.zzd.mapper.SysRoleResourceMapper;
import org.zzd.mapper.SysUserMapper;
import org.zzd.mapper.SysUserRoleMapper;
import org.zzd.pojo.SysResource;
import org.zzd.pojo.SysResourceExample;
import org.zzd.pojo.SysResourceExample.Criteria;
import org.zzd.pojo.SysRole;
import org.zzd.pojo.SysRoleResource;
import org.zzd.pojo.SysRoleResourceExample;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.SysUserRoleExample;
import org.zzd.pojo.SysUserRoleKey;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
* <p>Title:SysResourceServiceImpl </p>
* @author Arain
* @date2017年5月18日
 */
@Service
public class SysResourceServiceImpl implements SysResourceService{
	@Autowired
	private SysResourceMapper sysResourceMapper;
	@Autowired 
	private SysRoleResourceMapper sysRoleResourceMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Value("${ADMIN}")
	private Long admin;
	@Override
	public ArainResult save_01(SysResource resource,String resourceJsonss ) {
		if(resource.getId() != null) {
			if(resource.getPid() == null) {
				resource.setPid((long) 0);
			}
			//保存主信息
			resource.setAuthorization((short) 1);
			sysResourceMapper.updateByPrimaryKey(resource);
			
			//保存功能信息
			JSONArray resourceJsons=JSONArray.fromObject(resourceJsonss);
			if(!StringUtils.isEmpty(resourceJsons)&&resourceJsons.size()>0){
				@SuppressWarnings("unchecked")
				List<SysResource> sysResourceDtos=(List<SysResource>) JSONArray.toCollection(resourceJsons, SysResource.class);
				SysResourceExample example2 = new SysResourceExample();
				example2.createCriteria().andPidEqualTo(resource.getId());
				sysResourceMapper.deleteByExample(example2);
				for (SysResource sysResource : sysResourceDtos) {
					sysResource.setPid(resource.getId());
					sysResource.setId(Long.valueOf(IDUtil.genId()));
					sysResourceMapper.insert(sysResource);
				}
			}
			return ArainResult.ok();
			
		} else {
			//菜单
			if(resource.getPid() == null) {
				resource.setPid((long) 0);
			}
			//保存主信息
			resource.setId(Long.valueOf(IDUtil.genId()));
			resource.setAuthorization((short) 1);
			sysResourceMapper.insert(resource);
			
			//保存功能信息
			JSONArray resourceJsons=JSONArray.fromObject(resourceJsonss);
			if(!StringUtils.isEmpty(resourceJsons)&&resourceJsons.size()>0){
				@SuppressWarnings("unchecked")
				List<SysResource> sysResourceDtos=(List<SysResource>) JSONArray.toCollection(resourceJsons, SysResource.class);
				for (SysResource sysResource : sysResourceDtos) {
					sysResource.setPid(resource.getId());
					sysResource.setId(Long.valueOf(IDUtil.genId()));
					sysResourceMapper.insert(sysResource);
				}
			}
			
			SysRoleResource record = new SysRoleResource();
			record.setRoleId(admin);
			record.setChecked((short) 1);
			record.setResourceId(resource.getId());
			sysRoleResourceMapper.insert(record);
			return ArainResult.ok();
		}
	}

	@Override
	public ArainResult load_01(SysResource resource) {
		//本身
		SysResource sysResource = sysResourceMapper.selectByPrimaryKey(resource.getId());
		return ArainResult.ok(sysResource);
	}

	@Override
	public ArainResult loadResource(String roleId) {
		
		return null;
	}

	@Override
	public ArainResult loadResource(String roleId, String userType, String userId) {
		
		return null;
	}

	@Override
	public ArainResult load_edit_grid(SysResource resource) {
		JSONArray array = new JSONArray();
		
		SysResource sysResource2 = sysResourceMapper.selectByPrimaryKey(resource.getPid());
		if (sysResource2.getPid() == 0) {
			return ArainResult.ok();
		}
		
		//附属
		SysResourceExample example = new SysResourceExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(resource.getPid());
		
		List<SysResource> list = sysResourceMapper.selectByExample(example);
		for (SysResource sysResource : list) {
			JSONObject object = new JSONObject();
			object.accumulate("name", sysResource.getName());
			object.accumulate("target", sysResource.getTarget());
			object.accumulate("enabled", sysResource.getEnabled());
			object.accumulate("power", sysResource.getAuthorization());
			array.add(object);
			
		}
		return ArainResult.ok(array.toString());
	}

	@Override
	public ArainResult load_list() {
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		SysResourceExample example = new SysResourceExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo((long) 0);
		List<SysResource> list = sysResourceMapper.selectByExample(example);
		for (SysResource sysResource : list) {
			object.accumulate("ID_", sysResource.getId());
			object.accumulate("NAME_", sysResource.getName());
			object.accumulate("ENABLE_",DictUtil.load_dict(sysResource.getEnabled().toString(), "ENABLED_").getDispaly());
			object.accumulate("SORT_", sysResource.getSort());
			object.accumulate("TARGET_", sysResource.getTarget());
			object.accumulate("TYPE_", sysResource.getType());
			
			array.add(object);
		}
		return ArainResult.ok(array);
	}

	@Override
	public ArainResult load_list(long pid) {
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		SysResourceExample example = new SysResourceExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		List<SysResource> list = sysResourceMapper.selectByExample(example);
		for (SysResource sysResource : list) {
			object.accumulate("ID_", sysResource.getId());
			object.accumulate("NAME_", sysResource.getName());
			object.accumulate("ENABLE_",DictUtil.load_dict(sysResource.getEnabled().toString(), "ENABLED_").getDispaly());
			object.accumulate("SORT_", sysResource.getSort());
			object.accumulate("TARGET_", sysResource.getTarget());
			object.accumulate("TYPE_", sysResource.getType());
			
			array.add(object);
		}
		return ArainResult.ok(array);
	}

	@Override
	public ArainResult load_tree(SysUser sysUser) {
		JSONArray array = new JSONArray();
//		List<SysResource> sort = new ArrayList<>();
//		Set<SysResource> resList = new HashSet<SysResource>();
		sysUser = sysUserMapper.selectByPrimaryKey((long) sysUser.getId());
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		org.zzd.pojo.SysUserRoleExample.Criteria criteria = sysUserRoleExample.createCriteria();
		criteria.andUserIdEqualTo(sysUser.getId());
		List<SysUserRoleKey> sysUserRoleKeys = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		
		for (SysUserRoleKey sysUserRoleKey : sysUserRoleKeys) {
			Long roleId = sysUserRoleKey.getRoleId();
			 
			SysRoleResourceExample example = new SysRoleResourceExample();
			 org.zzd.pojo.SysRoleResourceExample.Criteria createCriteria = example.createCriteria();
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
					JSONObject object = new JSONObject();
					object.accumulate("id", sysResource.getId());
					object.accumulate("text", sysResource.getName());
					object.accumulate("state", "closed");
					//子
					JSONArray array1 = new JSONArray();
					SysResourceExample example1 = new SysResourceExample();
					Criteria criteria1 = example1.createCriteria();
					criteria1.andPidEqualTo(sysResource.getId());
					List<SysResource> list1 = sysResourceMapper.selectByExample(example1);
					for (SysResource sysResource1 : list1) {
						JSONObject object1 = new JSONObject();
						object1.accumulate("id", sysResource1.getId());
						object1.accumulate("text", sysResource1.getName());
						
						array1.add(object1);
					}
					object.accumulate("children", array1);
					array.add(object);
				}
			}
		}
		return ArainResult.ok(array.toString());
	}

	@Override
	public ArainResult load_tree(SysRole role,SysUser sysUser) {
		JSONArray array = new JSONArray();
		//加载角色所得的资源
		SysRoleResourceExample examplerole = new SysRoleResourceExample();
		org.zzd.pojo.SysRoleResourceExample.Criteria createCriteria = examplerole.createCriteria();
		createCriteria.andRoleIdEqualTo(role.getId());
		List<SysRoleResource> resourcesList = sysRoleResourceMapper.selectByExample(examplerole);
		
		sysUser = sysUserMapper.selectByPrimaryKey((long) sysUser.getId());
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		org.zzd.pojo.SysUserRoleExample.Criteria criteria = sysUserRoleExample.createCriteria();
		criteria.andUserIdEqualTo(sysUser.getId());
		List<SysUserRoleKey> sysUserRoleKeys = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		for (SysUserRoleKey sysUserRoleKey : sysUserRoleKeys) {
			Long roleId = sysUserRoleKey.getRoleId();
			 
			SysRoleResourceExample example = new SysRoleResourceExample();
			 org.zzd.pojo.SysRoleResourceExample.Criteria createCriteria1 = example.createCriteria();
			createCriteria1.andRoleIdEqualTo(roleId);
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
				
				List<SysResource> list1 = sysResourceMapper.selectByExample(resourceExample);
				for (SysResource sysResource : list1) {
					JSONObject object = new JSONObject();
					object.accumulate("id", sysResource.getId());
					object.accumulate("text", sysResource.getName());
					object.accumulate("state", "closed");
					//子
					JSONArray array1 = new JSONArray();
					SysResourceExample example1 = new SysResourceExample();
					Criteria criteria1 = example1.createCriteria();
					criteria1.andPidEqualTo(sysResource.getId());
					
					List<SysResource> list11 = sysResourceMapper.selectByExample(example1);
					for (SysResource sysResource1 : list11) {
						
						for (SysRoleResource sysRoleResource1 : list) {
							if(sysRoleResource1.getResourceId().toString().equals(sysResource1.getId().toString())) {
								JSONObject object1 = new JSONObject();
								object1.accumulate("id", sysResource1.getId());
								object1.accumulate("text", sysResource1.getName());
								
								in:for (SysRoleResource sysRoleResource11 : resourcesList) {
									if(sysResource1.getId().toString().equals(sysRoleResource11.getResourceId().toString())) {
										object1.accumulate("checked", true);
										try {
											Thread.sleep(10);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
										break in;
									}
								}
								array1.add(object1);
							}
						}
					}
					object.accumulate("children", array1);
					array.add(object);
				}
			}
		}
				return ArainResult.ok(array.toString());
	}

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
			org.zzd.pojo.SysRoleResourceExample.Criteria createCriteria = example.createCriteria();
			createCriteria.andRoleIdEqualTo(roleId);
			List<SysRoleResource> list = sysRoleResourceMapper.selectByExample(example);
			
			for (SysRoleResource sysRoleResource : list) {
				Long resourceId = sysRoleResource.getResourceId();
				SysResourceExample resourceExample = new SysResourceExample();
				resourceExample.setDistinct(true);
				resourceExample.setOrderByClause("sort_");
				org.zzd.pojo.SysResourceExample.Criteria createCriteria2 = resourceExample.createCriteria();
//				createCriteria2.andEnabledEqualTo((short) 1);
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
	public ArainResult load_child(long pid, SysUser sysUser) {
		Set<SysResource> resList = new HashSet<SysResource>();
		List<SysResource>  sort = new ArrayList<>();
		SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
		org.zzd.pojo.SysUserRoleExample.Criteria criteria = sysUserRoleExample.createCriteria();
		criteria.andUserIdEqualTo(sysUser.getId());
		List<SysUserRoleKey> sysUserRoleKeys = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		for (SysUserRoleKey sysUserRoleKey : sysUserRoleKeys) {
			Long roleId = sysUserRoleKey.getRoleId();
			SysRoleResourceExample example = new SysRoleResourceExample();
			org.zzd.pojo.SysRoleResourceExample.Criteria createCriteria = example.createCriteria();
			createCriteria.andRoleIdEqualTo(roleId);
			List<SysRoleResource> list = sysRoleResourceMapper.selectByExample(example);
			for (SysRoleResource sysRoleResource : list) {
				Long resourceId = sysRoleResource.getResourceId();
				SysResourceExample resourceExample = new SysResourceExample();
				resourceExample.setDistinct(true);
				resourceExample.setOrderByClause("sort_");
				org.zzd.pojo.SysResourceExample.Criteria createCriteria2 = resourceExample.createCriteria();
//				createCriteria2.andEnabledEqualTo((short) 1);
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

	@Override
	public List<String> load_icons() {
		List<String> iconsList = new ArrayList<>();
		SysResourceIcons[] icons = SysResourceIcons.values();
		for (SysResourceIcons sysResourceIcons : icons) {
			String string = sysResourceIcons.toString();
			string = "fa fa-"+string;
			iconsList.add(string);
		}
		return iconsList;
	}

}
