package org.zzd.system.role;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.IDUtil;
import org.zzd.common.util.JsonUtils;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.SysRoleMapper;
import org.zzd.mapper.SysRoleResourceMapper;
import org.zzd.mapper.SysUserMapper;
import org.zzd.mapper.SysUserRoleMapper;
import org.zzd.pojo.SysRole;
import org.zzd.pojo.SysRoleExample;
import org.zzd.pojo.SysRoleExample.Criteria;
import org.zzd.pojo.SysRoleResource;
import org.zzd.pojo.SysRoleResourceExample;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.SysUserRoleExample;
import org.zzd.pojo.SysUserRoleKey;

import com.github.pagehelper.PageHelper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
@PropertySource(value = "classpath:resources.properties",encoding = "utf-8")
public class SysRoleServiceImpl implements SysRoleService{
	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysRoleResourceMapper sysRoleResourceMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Value("${ADMIN}")
	private Long admin;

	@Override
	public ArainResult save_01(SysRole sysRole,String resourceIds,SysUser sysUser) {
		sysUser = sysUserMapper.selectByPrimaryKey(sysUser.getId());
		sysRole.setOrgid(sysUser.getOrgid());
		if(sysRole.getId() != null) {
			sysRole.setOperator(sysUser.getUsername()+"||"+sysUser.getRealname());
			sysRole.setOpTime(new Date());
			sysRoleMapper.updateByPrimaryKey(sysRole);
			
			SysRoleResourceExample roleResourceExample = new SysRoleResourceExample();
			roleResourceExample.createCriteria().andRoleIdEqualTo(sysRole.getId());
			sysRoleResourceMapper.deleteByExample(roleResourceExample);
			
			JSONArray array = JSONArray.fromObject(resourceIds);
			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = JSONObject.fromObject(array.get(i));
				SysRoleResource sysRoleResource=new SysRoleResource();
				sysRoleResource.setChecked((short) jsonObject.getInt("checked"));
				sysRoleResource.setResourceId(jsonObject.getLong("resourcesIds"));
				sysRoleResource.setRoleId(sysRole.getId());
				sysRoleResourceMapper.insert(sysRoleResource);
			}
			return ArainResult.ok(sysRole);
		} else {
			sysRole.setId(Long.valueOf(IDUtil.genId()));
			sysRole.setOperator(sysUser.getUsername()+"||"+sysUser.getRealname());
			sysRole.setOpTime(new Date());
			sysRoleMapper.insert(sysRole);
			
			JSONArray array = JSONArray.fromObject(resourceIds);
			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = JSONObject.fromObject(array.get(i));
				SysRoleResource sysRoleResource=new SysRoleResource();
				sysRoleResource.setChecked((short) jsonObject.getInt("checked"));
				sysRoleResource.setResourceId(jsonObject.getLong("resourcesIds"));
				sysRoleResource.setRoleId(sysRole.getId());
				sysRoleResourceMapper.insert(sysRoleResource);
			}
			return ArainResult.ok(sysRole);
		}
	}

	@Override
	public ArainResult load_01(SysRole sysRole) {
		SysRole role = sysRoleMapper.selectByPrimaryKey(sysRole.getId());
		return ArainResult.ok(role);
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
	public ArainResult loadOrgTree(String orgid) {
		
		return null;
	}

	@Override
	public ArainResult load_list(int page, int rows, String sort,String order,String name,Short enable,SysUser sysUser) {
		sysUser = sysUserMapper.selectByPrimaryKey(sysUser.getId());
		JSONObject out = new JSONObject();
		JSONArray array = new JSONArray();
		SysRoleExample example = new SysRoleExample();
		if(StringUtils.isNotBlank(order)) {
			example.setOrderByClause(sort+" "+order);
		} else {
			example.setOrderByClause(sort);
		}
		Criteria criteria = example.createCriteria();
		
		criteria.andIdNotEqualTo(admin).andOrgidEqualTo(sysUser.getOrgid());
		if(StringUtils.isNotBlank(name)) {
			criteria.andNameLike("%"+name+"%");
		}
		
		if(enable != null) {
			criteria.andEnabledEqualTo(enable);
		}
		PageHelper.startPage(page, rows);
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		int count = sysRoleMapper.countByExample(example);
		for (SysRole sysRole : list) {
			JSONObject object = new JSONObject();
			object.accumulate("ID_", sysRole.getId());
			object.accumulate("NAME_", sysRole.getName());
			if(sysRole.getSort() == null) {
				object.accumulate("SORT_","");
			} else {
			object.accumulate("SORT_", sysRole.getSort());
			}
			object.accumulate("OPERATOR_", sysRole.getOperator());
			object.accumulate("OP_TIME_", TimeUtil.format(sysRole.getOpTime()));
			object.accumulate("ENABLED_",DictUtil.load_dict(sysRole.getEnabled().toString(), "ENABLED_").getDispaly());
			array.add(object);
		}
		
		out.accumulate("total",count);
		out.accumulate("rows",array);
		return ArainResult.ok(JsonUtils.objectToJson(out));
	}

	@Override
	public ArainResult load_list(SysUser user) {
		user = sysUserMapper.selectByPrimaryKey(user.getId());
		SysRoleExample example = new SysRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andEnabledEqualTo((short) 1);
		SysUserRoleExample sysUserRoleExample= new SysUserRoleExample();
		sysUserRoleExample.createCriteria().andUserIdEqualTo(user.getId());
		List<SysUserRoleKey> list2 = sysUserRoleMapper.selectByExample(sysUserRoleExample);
		if(list2!=null && list2.size()>0) {
			for (SysUserRoleKey sysUserRoleKey : list2) {
				if (!sysUserRoleKey.getRoleId().equals(admin)) {
					criteria.andOrgidEqualTo(user.getOrgid().longValue());
				}
			}
		}
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		return ArainResult.ok(list);
	}

}
