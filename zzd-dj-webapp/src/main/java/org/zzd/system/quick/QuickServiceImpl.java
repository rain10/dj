package org.zzd.system.quick;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.mapper.SysResourceMapper;
import org.zzd.mapper.SysUserQuickMapper;
import org.zzd.pojo.SysResource;
import org.zzd.pojo.SysResourceExample;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.SysUserQuick;
import org.zzd.pojo.SysUserQuickExample;
import org.zzd.pojo.SysUserQuickKey;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 
* <p>Title:QuickServiceImpl </p>
* @author Arain
* @date2017年8月22日
 */
@Service
public class QuickServiceImpl implements QuickService{
	@Autowired
	private SysUserQuickMapper sysUserQuickMapper;
	@Autowired
	private SysResourceMapper sysResourceMapper;
	@Override
	public ArainResult save_01(SysUserQuickKey key, SysUser user) {
		SysUserQuick record = new SysUserQuick();
		record.setResourceId(key.getResourceId());
		record.setUserId(user.getId());
		record.setDate(new Date());
		sysUserQuickMapper.insert(record);
		return ArainResult.ok();
	}

	@Override
	public ArainResult load_01(SysUserQuickKey key, SysUser user) {
		SysUserQuickExample example = new SysUserQuickExample();
		example.createCriteria().andUserIdEqualTo(user.getId()).andResourceIdEqualTo(key.getResourceId());
		List<SysUserQuick> list = sysUserQuickMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			return ArainResult.build(400,"已有此快捷菜单");
		}
		return ArainResult.ok();
	}

	@Override
	public ArainResult load_list(SysUser user) {
		SysUserQuickExample example = new SysUserQuickExample();
		example.createCriteria().andUserIdEqualTo(user.getId());
		List<Long> longs = new ArrayList<>();
		List<SysUserQuick> list = sysUserQuickMapper.selectByExample(example);
		for (SysUserQuick sysUserQuick : list) {
			longs.add(sysUserQuick.getResourceId());
		}
		if(longs!=null && longs.size()>0) {
			JSONArray array = new JSONArray();
			SysResourceExample sysResourceExample = new SysResourceExample();
			sysResourceExample.createCriteria().andIdIn(longs);
			List<SysResource> list2 = sysResourceMapper.selectByExample(sysResourceExample);
			for (SysResource sysResource : list2) {
				JSONObject object = new JSONObject();
				object.put("id", sysResource.getId());
				object.put("name", sysResource.getName());
				
				array.add(object);
			}
			return ArainResult.ok(array);
		}
		return ArainResult.build(400, "暂无数据");
	}

	@Override
	public ArainResult delete_01(SysUserQuickKey key, SysUser user) {
		SysUserQuickExample example = new SysUserQuickExample();
		example.createCriteria().andResourceIdEqualTo(key.getResourceId()).andUserIdEqualTo(user.getId());
		sysUserQuickMapper.deleteByExample(example);
		return ArainResult.ok();
	}

}
