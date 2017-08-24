package org.zzd.system.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.IDUtil;
import org.zzd.mapper.SysDepartmentMapper;
import org.zzd.mapper.SysGroupMapper;
import org.zzd.mapper.SysOrganizationMapper;
import org.zzd.mapper.SysUserMapper;
import org.zzd.pojo.SysDepartment;
import org.zzd.pojo.SysDepartmentExample;
import org.zzd.pojo.SysGroup;
import org.zzd.pojo.SysGroupExample;
import org.zzd.pojo.SysUser;

import com.alibaba.fastjson.JSONObject;

import net.sf.json.JSONArray;

/**
 * 
 * <p>
 * Title:SysDepartmentServiceImpl
 * </p>
 * 
 * @author Arain
 * @date2017年8月14日
 */
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {
	@Autowired
	private SysDepartmentMapper sysDepartmentMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysOrganizationMapper sysOrganizationMapper;
	@Autowired
	private SysGroupMapper sysGroupMapper;

	@Override
	public ArainResult load_orgid(SysUser user) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
		SysGroupExample example = new SysGroupExample();
		example.createCriteria().andOrgidEqualTo(sysUser.getOrgid());
		List<SysGroup> list = sysGroupMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			return ArainResult.ok(list.get(0));
		}
		return ArainResult.ok();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArainResult save_01(Long id, String dept) {
		SysDepartmentExample example = new SysDepartmentExample();
		example.createCriteria().andOrganizationIdEqualTo(id);
		sysDepartmentMapper.deleteByExample(example);

		JSONArray array = JSONArray.fromObject(dept);
		List<DeptPojo> collection = (List<DeptPojo>) JSONArray.toCollection(array, DeptPojo.class);
		for (DeptPojo deptPojo : collection) {
			SysDepartment department = new SysDepartment();
			department.setId(Long.valueOf(IDUtil.genId()));
			department.setName(deptPojo.getName());
			department.setEnabled(deptPojo.getEnabled());
			department.setNumber(deptPojo.getNumber());
			department.setOrganizationId(id);

			sysDepartmentMapper.insert(department);
		}
		return ArainResult.ok();
	}

	@Override
	public ArainResult load_orgid(Long orgid) {
		com.alibaba.fastjson.JSONArray array = new com.alibaba.fastjson.JSONArray();
		SysDepartmentExample example = new SysDepartmentExample();
		example.createCriteria().andOrganizationIdEqualTo(orgid).andEnabledEqualTo((short) 1);
		List<SysDepartment> list = sysDepartmentMapper.selectByExample(example);
		for (SysDepartment sysDepartment : list) {
			JSONObject object = new JSONObject();
			object.put("name", sysDepartment.getName());
			object.put("target", sysDepartment.getNumber());
			if (sysDepartment.getEnabled() == 1) {
				object.put("dept", 1);
			} else {
				object.put("dept", 0);
			}
			array.add(object);
		}
		return ArainResult.ok(array);
	}

	@Override
	public ArainResult load_01(SysUser user) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
		com.alibaba.fastjson.JSONArray array = new com.alibaba.fastjson.JSONArray();
		SysDepartmentExample example = new SysDepartmentExample();
		example.createCriteria().andEnabledEqualTo((short) 1).andOrganizationIdEqualTo(sysUser.getOrgid());
		List<SysDepartment> list = sysDepartmentMapper.selectByExample(example);
		for (SysDepartment sysDepartment : list) {
			JSONObject object = new JSONObject();
			object.put("id", sysDepartment.getId());
			object.put("text", sysDepartment.getName());
			
			array.add(object);
		}
		return ArainResult.ok(array);
	}

	@Override
	public String load_dept_name(SysUser user) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
		SysDepartment department = sysDepartmentMapper.selectByPrimaryKey(sysUser.getDepid());
		if(department!=null) {
			return department.getName();
		}
		return "";
	}

	@Override
	public ArainResult save_group(SysGroup group) {
		if(group.getId()!=null) {
			int i = sysGroupMapper.updateByPrimaryKey(group);
			if(i==1) {
				return ArainResult.ok(group.getId());
			}
			return ArainResult.build(400, "信息错误");
		}
		int i = sysGroupMapper.insert(group);
		if(i==1) {
			return ArainResult.ok(group.getId());
		}
		return ArainResult.build(400, "信息错误");
	}

}
