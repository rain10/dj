package org.zzd.system.orgid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.IDUtil;
import org.zzd.mapper.SysOrganizationMapper;
import org.zzd.pojo.SysOrganization;
import org.zzd.pojo.SysOrganizationExample;
import org.zzd.pojo.SysOrganizationExample.Criteria;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
* <p>Title:SysOrgidServiceImpl </p>
* @author Arain
* @date2017年6月9日
 */

@Service
public class SysOrgidServiceImpl implements SysOrgidService {
	@Autowired
	private SysOrganizationMapper sysOrganizationMapper;
	@Override
	public String load_datagrid(Long city) {
		if(city != null) {
			JSONArray array = new JSONArray();
			SysOrganizationExample example = new SysOrganizationExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andIdEqualTo(city);
			List<SysOrganization> list = sysOrganizationMapper.selectByExample(example);
			for (SysOrganization sysOrganization : list) {
				JSONObject object = new JSONObject();
				object.accumulate("id", sysOrganization.getId());
				object.accumulate("text", sysOrganization.getName());
				JSONArray array1 = new JSONArray();
				
				SysOrganizationExample example2 = new SysOrganizationExample();
				example2.createCriteria().andPidEqualTo(sysOrganization.getId());
				List<SysOrganization> list2 = sysOrganizationMapper.selectByExample(example2);
				for (SysOrganization sysOrganization2 : list2) {
					JSONObject object2 = new JSONObject();
					object2.accumulate("id", sysOrganization2.getId());
					object2.accumulate("text", sysOrganization2.getName());
					
					JSONArray array2 = new JSONArray();
					SysOrganizationExample example3 = new SysOrganizationExample();
					example3.createCriteria().andPidEqualTo(sysOrganization2.getId());
					List<SysOrganization> list3 = sysOrganizationMapper.selectByExample(example3);
					if(list3!=null&&list3.size()>0) {
						object2.accumulate("state", "closed");
						in:for (SysOrganization sysOrganization3 : list3) {
							JSONObject object3 = new JSONObject();
							object3.accumulate("id", sysOrganization3.getId());
							object3.accumulate("text", sysOrganization3.getName());
							
							JSONArray array3 = new JSONArray();
							SysOrganizationExample example4 = new SysOrganizationExample();
							example4.createCriteria().andPidEqualTo(sysOrganization3.getId());
							List<SysOrganization> list4 = sysOrganizationMapper.selectByExample(example4);
							if(list4!=null && list4.size()>0) {
								object3.accumulate("state", "closed");
								for (SysOrganization sysOrganization4 : list4) {
									JSONObject object4 = new JSONObject();
									object4.accumulate("id", sysOrganization4.getId());
									object4.accumulate("text", sysOrganization4.getName());
									
									JSONArray array4 = new JSONArray();
									SysOrganizationExample example5 = new SysOrganizationExample();
									example5.createCriteria().andPidEqualTo(sysOrganization4.getId());
									List<SysOrganization> list5 = sysOrganizationMapper.selectByExample(example5);
									if(list5!=null && list5.size()>0) {
										object4.accumulate("state", "closed");
										for (SysOrganization sysOrganization5 : list5) {
											JSONObject object5 = new JSONObject();
											object5.accumulate("id", sysOrganization5.getId());
											object5.accumulate("text", sysOrganization5.getName());
											
											array4.add(object5);
										}
									}
									object4.accumulate("children", array4);
									array3.add(object4);
								}
								
								object3.accumulate("children", array3);
							}
							
							array2.add(object3);
							}
						
						object2.accumulate("children", array2);
					}
					
					
					array1.add(object2);
				}
				
				object.accumulate("children", array1);
				array.add(object);
			}
			
			return array.toString();
		}
		
		
		JSONArray array = new JSONArray();
		SysOrganizationExample example = new SysOrganizationExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo((long) 0);
		List<SysOrganization> list = sysOrganizationMapper.selectByExample(example);
		for (SysOrganization sysOrganization : list) {
			JSONObject object = new JSONObject();
			object.accumulate("id", sysOrganization.getId());
			object.accumulate("text", sysOrganization.getName());
//			object.accumulate("state", "closed");
			JSONArray array1 = new JSONArray();
			
			SysOrganizationExample example2 = new SysOrganizationExample();
			example2.createCriteria().andPidEqualTo(sysOrganization.getId());
			List<SysOrganization> list2 = sysOrganizationMapper.selectByExample(example2);
			for (SysOrganization sysOrganization2 : list2) {
				JSONObject object2 = new JSONObject();
				object2.accumulate("id", sysOrganization2.getId());
				object2.accumulate("text", sysOrganization2.getName());
				
				
				
				JSONArray array2 = new JSONArray();
				SysOrganizationExample example3 = new SysOrganizationExample();
				example3.createCriteria().andPidEqualTo(sysOrganization2.getId());
				List<SysOrganization> list3 = sysOrganizationMapper.selectByExample(example3);
				if(list3 != null && list3.size() > 0) {
					object2.accumulate("state", "closed");
					in:for (SysOrganization sysOrganization3 : list3) {
						JSONObject object3 = new JSONObject();
						object3.accumulate("id", sysOrganization3.getId());
						object3.accumulate("text", sysOrganization3.getName());
						
						JSONArray array3 = new JSONArray();
						SysOrganizationExample example4 = new SysOrganizationExample();
						example4.createCriteria().andPidEqualTo(sysOrganization3.getId());
						List<SysOrganization> list4 = sysOrganizationMapper.selectByExample(example4);
						if(list4!=null && list4.size()>0) {
							object3.accumulate("state", "closed");
							for (SysOrganization sysOrganization4 : list4) {
								JSONObject object4 = new JSONObject();
								object4.accumulate("id", sysOrganization4.getId());
								object4.accumulate("text", sysOrganization4.getName());
								
								JSONArray array4 = new JSONArray();
								SysOrganizationExample example5 = new SysOrganizationExample();
								example5.createCriteria().andPidEqualTo(sysOrganization4.getId());
								List<SysOrganization> list5 = sysOrganizationMapper.selectByExample(example5);
								if(list5!=null && list5.size()>0) {
									object4.accumulate("state", "closed");
									for (SysOrganization sysOrganization5 : list5) {
										JSONObject object5 = new JSONObject();
										object5.accumulate("id", sysOrganization5.getId());
										object5.accumulate("text", sysOrganization5.getName());
										
										array4.add(object5);
									}
								}
								object4.accumulate("children", array4);
								array3.add(object4);
							}
							
							object3.accumulate("children", array3);
						}
						
						array2.add(object3);
						}
					} 
				
				object2.accumulate("children", array2);
				array1.add(object2);
			}
			
			object.accumulate("children", array1);
			array.add(object);
		}
		
		return array.toString();
	}
	@Override
	public String load_map() {
		SysOrganizationExample example = new SysOrganizationExample();
		JSONArray array = new JSONArray();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo((long) 510000);
		List<SysOrganization> list = sysOrganizationMapper.selectByExample(example);
		for (SysOrganization sysOrganization : list) {
			JSONObject object = new JSONObject();
			object.accumulate("name", sysOrganization.getName());
			object.accumulate("value", sysOrganization.getId());
			
			array.add(object);
		}
		return array.toString();
	}
	@Override
	public String load_tree() {
		JSONArray array = new JSONArray();
		SysOrganizationExample example = new SysOrganizationExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo((long) 0).andEnabledEqualTo((short) 1);
		List<SysOrganization> list = sysOrganizationMapper.selectByExample(example);
		for (SysOrganization sysOrganization : list) {
			JSONObject object = new JSONObject();
			object.accumulate("id", sysOrganization.getId());
			object.accumulate("text", sysOrganization.getName());
			JSONArray array1 = new JSONArray();
			
			SysOrganizationExample example2 = new SysOrganizationExample();
			example2.createCriteria().andPidEqualTo(sysOrganization.getId()).andEnabledEqualTo((short) 1);
			List<SysOrganization> list2 = sysOrganizationMapper.selectByExample(example2);
			for (SysOrganization sysOrganization2 : list2) {
				JSONObject object2 = new JSONObject();
				object2.accumulate("id", sysOrganization2.getId());
				object2.accumulate("text", sysOrganization2.getName());
				
				JSONArray array2 = new JSONArray();
				SysOrganizationExample example3 = new SysOrganizationExample();
				example3.createCriteria().andPidEqualTo(sysOrganization2.getId());
				List<SysOrganization> list3 = sysOrganizationMapper.selectByExample(example3);
				if(list3 != null && list3.size() > 0) {
					object2.accumulate("state", "closed");
					in:for (SysOrganization sysOrganization3 : list3) {
						JSONObject object3 = new JSONObject();
						object3.accumulate("id", sysOrganization3.getId());
						object3.accumulate("text", sysOrganization3.getName());
						
						JSONArray array3 = new JSONArray();
						SysOrganizationExample example4 = new SysOrganizationExample();
						example4.createCriteria().andPidEqualTo(sysOrganization3.getId());
						List<SysOrganization> list4 = sysOrganizationMapper.selectByExample(example4);
						if(list4!=null && list4.size()>0) {
							object3.accumulate("state", "closed");
							for (SysOrganization sysOrganization4 : list4) {
								JSONObject object4 = new JSONObject();
								object4.accumulate("id", sysOrganization4.getId());
								object4.accumulate("text", sysOrganization4.getName());
								
								JSONArray array4 = new JSONArray();
								SysOrganizationExample example5 = new SysOrganizationExample();
								example5.createCriteria().andPidEqualTo(sysOrganization4.getId());
								List<SysOrganization> list5 = sysOrganizationMapper.selectByExample(example5);
								if(list5!=null && list5.size()>0) {
									object4.accumulate("state", "closed");
									for (SysOrganization sysOrganization5 : list5) {
										JSONObject object5 = new JSONObject();
										object5.accumulate("id", sysOrganization5.getId());
										object5.accumulate("text", sysOrganization5.getName());
										
										array4.add(object5);
									}
								}
								object4.accumulate("children", array4);
								array3.add(object4);
							}
							
							object3.accumulate("children", array3);
						}
						
						array2.add(object3);
						}
					} 
				
				object2.accumulate("children", array2);
				array1.add(object2);
			}
			
			object.accumulate("children", array1);
			array.add(object);
		}
		
		return array.toString();
	}
	@Override
	public ArainResult save_01(SysOrganization sysOrganization) {
		if(sysOrganization.getId() != null) {
			sysOrganizationMapper.updateByPrimaryKey(sysOrganization);
			return ArainResult.ok();
		}
		sysOrganization.setId(Long.valueOf(IDUtil.genId()));
		sysOrganizationMapper.insert(sysOrganization);
		return ArainResult.ok();
	}
	@Override
	public ArainResult load_01(SysOrganization sysOrganization) {
		SysOrganization organization = sysOrganizationMapper.selectByPrimaryKey(sysOrganization.getId());
		return ArainResult.ok(organization);
	}

}
