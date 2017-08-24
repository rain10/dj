package org.zzd.system.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.IDUtil;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.SysOrganizationMapper;
import org.zzd.mapper.SysResourceMapper;
import org.zzd.mapper.SysRoleResourceMapper;
import org.zzd.mapper.SysUserMapper;
import org.zzd.mapper.SysUserRoleMapper;
import org.zzd.pojo.ExaminationPaper;
import org.zzd.pojo.ExaminationPaperExample;
import org.zzd.pojo.SysOrganization;
import org.zzd.pojo.SysOrganizationExample;
import org.zzd.pojo.SysResource;
import org.zzd.pojo.SysResourceExample;
import org.zzd.pojo.SysRoleResource;
import org.zzd.pojo.SysRoleResourceExample;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.SysUserExample;
import org.zzd.pojo.SysUserExample.Criteria;
import org.zzd.pojo.SysUserRoleExample;
import org.zzd.pojo.SysUserRoleKey;

import com.github.pagehelper.PageHelper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
* <p>Title:UserServiceImpl </p>
* @author Arain
* @date2017年5月22日
 */
@Service
public class SysUserServiceImpl implements SysUserService{
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	private SysResourceMapper sysResourceMapper;
	@Autowired
	private SysRoleResourceMapper sysRoleResourceMapper;
	@Autowired
	private SysOrganizationMapper sysOrganizationMapper;
	@Value("${PASSWORD}")
	private String password;
	@Value("${ADMIN_ID}")
	private Long admin_id;
	
	@Override
	public ArainResult save_01(SysUser SysUser,String[] roles) {
		if (SysUser.getId() != null) {
			if (StringUtils.isBlank(SysUser.getPassword())) {
				SysUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
			}
			sysUserMapper.updateByPrimaryKey(SysUser);
			
			SysUserRoleExample example = new SysUserRoleExample();
			example.createCriteria().andUserIdEqualTo(SysUser.getId());
			sysUserRoleMapper.deleteByExample(example);
			
			for (String roleid : roles) {
				SysUserRoleKey record = new SysUserRoleKey();
				
				record.setRoleId(Long.valueOf(roleid));
				record.setUserId(SysUser.getId());
				
				sysUserRoleMapper.insert(record);
			}
			return ArainResult.ok(SysUser);
		} else {
			SysUserExample example1 = new SysUserExample();
			example1.createCriteria().andUsernameEqualTo(SysUser.getUsername());
			List<SysUser> list = sysUserMapper.selectByExample(example1);
			if(list!=null && list.size()>0) {
				return ArainResult.build(400,"用户名重复！");
			}
			SysUser.setId(Long.valueOf(IDUtil.genId()));
			if (StringUtils.isBlank(SysUser.getPassword())) {
				SysUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
			}
			sysUserMapper.insert(SysUser);
			for (String roleid : roles) {
				SysUserRoleKey record = new SysUserRoleKey();
				record.setRoleId(Long.valueOf(roleid));
				record.setUserId(SysUser.getId());
				sysUserRoleMapper.insert(record);
			}
			return ArainResult.ok(SysUser);
		}
	}

	@Override
	public ArainResult load_01(SysUser SysUser) {
		JSONObject object = new JSONObject();
		SysUser user = sysUserMapper.selectByPrimaryKey(SysUser.getId());
		SysUserRoleExample example = new SysUserRoleExample();
		example.createCriteria().andUserIdEqualTo(SysUser.getId());
		List<SysUserRoleKey> list = sysUserRoleMapper.selectByExample(example);
		object.accumulate("sysUser", user);
		object.accumulate("sysRole", list);
		return ArainResult.ok(object);
	}

	@Override
	public ArainResult loadOrgTree(String orgid) {

		return null;
	}

	@Override
	public ArainResult load_list(int page, int rows, String sort, String order, String username, Short enable,
			String realname,SysUser user,Short type) {
		JSONObject out = new JSONObject();
		JSONArray array = new JSONArray();
		
		SysUserExample example = new SysUserExample();
		if(StringUtils.isNotBlank(order)) {
			example.setOrderByClause(sort+" "+order);
		} else {
			example.setOrderByClause(sort);
		}
		Criteria criteria = example.createCriteria();
		user = sysUserMapper.selectByPrimaryKey(user.getId());
		criteria.andIdNotEqualTo(user.getId());
		
		if(type!=null) {
			criteria.andUsertypeEqualTo((Short)type);
		}
		
		if(user.getId().toString().equals(admin_id.toString()) && 0 == type) {
		} else if(!user.getId().toString().equals(admin_id.toString()) && 0==type){
//			SysOrganizationExample sysOrganizationExample = new SysOrganizationExample();
//			sysOrganizationExample.createCriteria().andPidEqualTo(user.getOrgid());
//			List<SysOrganization> list = sysOrganizationMapper.selectByExample(sysOrganizationExample);
//			List<Long> orgid_list = new ArrayList<>();
//			for (SysOrganization sysOrganization : list) {
//				orgid_list.add(sysOrganization.getId());
//			}
			List<Long> orgid_list = sysOrganizationMapper.selectByOrgid(user.getOrgid());
			criteria.andOrgidIn(orgid_list);
		} else {
			criteria.andOrgidEqualTo(user.getOrgid());
		}
		
		if(StringUtils.isNotBlank(username)) {
			criteria.andUsernameLike("%"+username+"%");
		}
		
		if(StringUtils.isNotBlank(realname)) {
			criteria.andRealnameLike("%"+realname+"%");
		}
		
		if(enable != null) {
			criteria.andEnabledEqualTo(enable);
		}
		PageHelper.startPage(page, rows);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		int count = sysUserMapper.countByExample(example);
		for (SysUser sysUser : list) {
			JSONObject object = new JSONObject();
			object.accumulate("ID_", sysUser.getId());
			object.accumulate("USERNAME_", sysUser.getUsername());
			object.accumulate("REALNAME_", sysUser.getRealname());
			object.accumulate("EMAIL_", sysUser.getEmail());
			object.accumulate("PHONE_", sysUser.getPhone());
			object.accumulate("ENABLED_",DictUtil.load_dict(sysUser.getEnabled().toString(), "ENABLED_").getDispaly());
			
			array.add(object);
		}
		
		out.accumulate("total",count);
		out.accumulate("rows",array);
		
		return ArainResult.ok(out.toString());
	}

	@Override
	public ArainResult load_login(SysUser user) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername()).andEnabledEqualTo((short) 1);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			for (SysUser sysUser : list) {
				if(sysUser.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))) {
					sysUser.setPassword("");
					return ArainResult.ok(sysUser);
				} else {
					return ArainResult.build(203, "用户名或密码错误！");
				}
			}
		} 
		return ArainResult.build(203, "用户名或密码错误！");
	}

	@Override
	public ArainResult load_shiro(String url,SysUser sysUser) {
		SysUserRoleExample example = new SysUserRoleExample();
		example.createCriteria().andUserIdEqualTo(sysUser.getId());
		List<SysUserRoleKey> list = sysUserRoleMapper.selectByExample(example);
		for (SysUserRoleKey sysUserRoleKey : list) {
			SysRoleResourceExample roleResourceExample = new SysRoleResourceExample();
			org.zzd.pojo.SysRoleResourceExample.Criteria createCriteria = roleResourceExample.createCriteria();
			createCriteria.andRoleIdEqualTo(sysUserRoleKey.getRoleId()).andCheckedEqualTo((short) 1);
			//.andCheckedEqualTo((short) 1)
			List<SysRoleResource> list2 = sysRoleResourceMapper.selectByExample(roleResourceExample);
			
			for (SysRoleResource sysRoleResource : list2) {
				SysResourceExample resourceExample = new SysResourceExample();
				resourceExample.createCriteria().andPidEqualTo(sysRoleResource.getResourceId());
				List<SysResource> list3 = sysResourceMapper.selectByExample(resourceExample);
				for (SysResource sysResource : list3) {
					if(sysResource.getTarget().contains(url)) {
						return ArainResult.ok();
					} 
					SysResourceExample resourceExamplep = new SysResourceExample();
					resourceExamplep.createCriteria().andIdEqualTo(sysResource.getPid());
					List<SysResource> parent = sysResourceMapper.selectByExample(resourceExamplep);
					if (parent != null && parent.size() > 0) {
						SysResource resource = parent.get(0);
						if(resource.getTarget().contains(url)) {
							return ArainResult.ok();
						} 
					}
					
//					SysResourceExample sysResourceExample = new SysResourceExample();
//					sysResourceExample.createCriteria().andPidEqualTo(sysResource.getId());
//					List<SysResource> list4 = sysResourceMapper.selectByExample(sysResourceExample);
//					for (SysResource sysResource2 : list4) {
//						if(url.equals(sysResource2.getTarget())) {
//							return ArainResult.ok();
//						} 
//					}
				}
			}
		}
		return ArainResult.build(400, "没有权限");
	}

	@Override
	public ArainResult save_password_edit(String oldpassword, String newpassword,SysUser user) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
		if (!DigestUtils.md5DigestAsHex(oldpassword.getBytes()).equals(sysUser.getPassword())) {
			return ArainResult.build(203, "原密码错误！");
		}
		
		if(DigestUtils.md5DigestAsHex(newpassword.getBytes()).equals(sysUser.getPassword())) {
			return ArainResult.build(203, "两次密码相同错误！");
		}
		
		sysUser.setPassword(DigestUtils.md5DigestAsHex(newpassword.getBytes()));
		sysUserMapper.updateByPrimaryKey(sysUser);
		
		return ArainResult.ok();
	}

	@Override
	public void save_image(SysUser user, String url) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
		sysUser.setPrphone(url);
		
		sysUserMapper.updateByPrimaryKey(sysUser);
		
	}

	@Override
	public Long load_first_orgid() {
		SysOrganizationExample example = new SysOrganizationExample();
		example.createCriteria().andEnabledEqualTo((short) 1).andPidEqualTo((long) 0);
		List<SysOrganization> list = sysOrganizationMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			return list.get(0).getId();
		}
		return (long) 510000;
	}

	@Override
	public Long load_first_orgid(SysUser user) {
		user = sysUserMapper.selectByPrimaryKey(user.getId());
		return user.getOrgid();
	}

	@Override
	public ArainResult load_combogrid(int page, int rows, String sort, String order, String q, SysUser user) {
		JSONArray array = new JSONArray();
		SysUserExample example = new SysUserExample();
		List<Long> orgid_list = sysOrganizationMapper.selectByOrgid(user.getOrgid());
		Criteria criteria = example.createCriteria().andEnabledEqualTo((short) 1).andUsertypeEqualTo((short) 0).andOrgidIn(orgid_list);;
		if(StringUtils.isNotBlank(q)) {
			criteria.andUsernameEqualTo(q);
		}
		
		PageHelper.startPage(page, rows);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		int count = sysUserMapper.countByExample(example);
		for (SysUser sysUser : list) {
			JSONObject object = new JSONObject();
			object.put("id_", sysUser.getId());
			object.put("username_", sysUser.getUsername());
			object.put("realname_", sysUser.getRealname());
			array.add(object);
		}
		JSONObject object = new JSONObject();
		object.put("total", count);
		object.put("rows", array);
		return ArainResult.ok(object);
	}

}
