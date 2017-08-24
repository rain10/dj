package org.zzd.app.content;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.pojo.DictPojo;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.ContentAttachmentsMapper;
import org.zzd.mapper.ContentMapper;
import org.zzd.mapper.ContentPropellingMapper;
import org.zzd.mapper.SysAttachmentsMapper;
import org.zzd.pojo.Content;
import org.zzd.pojo.ContentAttachmentsExample;
import org.zzd.pojo.ContentAttachmentsKey;
import org.zzd.pojo.ContentExample;
import org.zzd.pojo.ContentExample.Criteria;
import org.zzd.pojo.ContentPropelling;
import org.zzd.pojo.ContentPropellingExample;
import org.zzd.pojo.ContentPropellingKey;
import org.zzd.pojo.SysAttachments;
import org.zzd.pojo.SysUser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

@Service
public class ContentServiceImp implements ContentService{
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private ContentAttachmentsMapper contentAttachmentsMapper;
	@Autowired
	private SysAttachmentsMapper sysAttachmentsMapper;
	@Autowired
	private ContentPropellingMapper contentPropellingMapper;
	@Override
	public ArainResult load_grid(int page, int rows, String sort, String order, String title,Integer type,SysUser user) {
		ContentExample example = new ContentExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTypeEqualTo(type).andEnabledEqualTo(1).andOrgidEqualTo(user.getOrgid());
		if(StringUtils.isNotBlank(order)) {
			example.setOrderByClause(sort+" "+order);
		} else {
			example.setOrderByClause(sort);
		}
		if(StringUtils.isNotBlank(title)) {
			createCriteria.andTitleLike("%"+title+"%");
		}
		PageHelper.startPage(page, rows);
		List<Content> list = contentMapper.selectByExample(example);
		int count = contentMapper.countByExample(example);
		JSONArray array = new JSONArray();
		for (Content content : list) {
			JSONObject object = new JSONObject();
			object.put("ID_", content.getId());
			object.put("title_",content.getTitle());
			object.put("manager_", content.getManager());
			object.put("maneger_time_",TimeUtil.format( content.getManegerTime()));
			object.put("enabled_",DictUtil.load_dict(content.getEnabled().toString(),"ENABLED_").getDispaly());
			
			array.add(object);
		}
		
		JSONObject object = new JSONObject();
		object.put("total",count);
		object.put("rows", array);
		return ArainResult.ok(object);
	}

	@Override
	public ArainResult save_01(Content content,String[] imageId) {
		if(content.getId()!=null) {
//			content.setType(1);
			contentMapper.updateByPrimaryKeyWithBLOBs(content);
			ContentAttachmentsExample example = new ContentAttachmentsExample();
			example.createCriteria().andContentIdEqualTo(content.getId());
			contentAttachmentsMapper.deleteByExample(example);
		} else {
//			content.setType(1);
			contentMapper.insert(content);
			
			
		}
		if(imageId!=null && imageId.length>0) {
			for (String string : imageId) {
				ContentAttachmentsKey contentAttachmentsKey = new ContentAttachmentsKey();
				contentAttachmentsKey.setAttachmentsId(Long.valueOf(string));
				contentAttachmentsKey.setContentId(content.getId());
				contentAttachmentsMapper.insert(contentAttachmentsKey);
				
				SysAttachments attachments = sysAttachmentsMapper.selectByPrimaryKey(Long.valueOf(string));
				attachments.setEnabled(1);
				sysAttachmentsMapper.updateByPrimaryKey(attachments);
			}
			return ArainResult.ok();
		}
		return ArainResult.ok();
		
	}

	@Override
	public ArainResult load_01(Content content) {
		content = contentMapper.selectByPrimaryKey(content.getId());
		return ArainResult.ok(content);
	}

	@Override
	public ArainResult load_all_count(SysUser user) {
		JSONArray array = new JSONArray();
		Date date = new Date();
		Date addDay_7 = TimeUtil.addDay(date,-6);
		int target = 0;
		for (int i = 0; i < 7; i++) {
			Date addDay = TimeUtil.addDay(addDay_7,target);
			String format = TimeUtil.format(addDay, TimeUtil.FORMAT_SHORT);
			int count = contentMapper.selectCountByDate(user.getOrgid().toString(),format);
			JSONObject object= new JSONObject();
			object.put("time",format);
			object.put("count", count);
			
			array.add(object);
			target++;
		}
		return ArainResult.ok(array);
	}

	@Override
	public ArainResult load_all_type(SysUser user) {
		JSONArray array = new JSONArray();
		
		List<DictPojo> list = DictUtil.load_dict_list("contentType");
		for (DictPojo dictPojo : list) {
			ContentExample example = new ContentExample();
			Criteria criteria = example.createCriteria().andEnabledEqualTo(1).andOrgidEqualTo(user.getOrgid());
			criteria.andTypeEqualTo(Integer.valueOf(dictPojo.getValue()));
			int count = contentMapper.countByExample(example);
			JSONObject object= new JSONObject();
			object.put("name", dictPojo.getDispaly());
			object.put("value", count);
			
			array.add(object);
		}
		return ArainResult.ok(array);
	}

	@Override
	public ArainResult save_send(String propellingTime,ContentPropellingKey key) {
		ContentPropellingExample example = new ContentPropellingExample();
		example.createCriteria().andContentIdEqualTo(key.getContentId()).andUserIdEqualTo(key.getUserId());
		List<ContentPropelling> list = contentPropellingMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			return ArainResult.build(400, "您已向该用户推送过此信息！");
		}
		
		ContentPropelling propelling = new ContentPropelling();
		String now = TimeUtil.getNow(TimeUtil.FORMAT_INT);
		Date date = TimeUtil.parse(propellingTime);
		String start = TimeUtil.format(date, TimeUtil.FORMAT_INT);
		if(Long.valueOf(now) > Long.valueOf(start)) {
			return ArainResult.build(400, "您的推送时间小于当前时间！");
		}
		propelling.setIng(0);
		propelling.setPropellingTime(date);
		propelling.setUserId(key.getUserId());
		propelling.setContentId(key.getContentId());
		contentPropellingMapper.insert(propelling);
		return ArainResult.ok();
	}

	@Override
	public ArainResult load_send(SysUser user) {
		JSONArray array = new JSONArray();
		ContentPropellingExample example = new ContentPropellingExample();
		example.createCriteria().andIngEqualTo(1).andUserIdEqualTo(user.getId());
		List<ContentPropelling> list = contentPropellingMapper.selectByExample(example);
		int i = contentPropellingMapper.countByExample(example);
		for (ContentPropelling contentPropelling : list) {
			JSONObject object = new JSONObject();
			Content content = contentMapper.selectByPrimaryKey(contentPropelling.getContentId());
			object.put("content_id_", contentPropelling.getContentId());
			object.put("user_id_", contentPropelling.getUserId());
			object.put("title_", content.getTitle());
			object.put("content_",content.getContent());
			object.put("propelling_time_", TimeUtil.format(contentPropelling.getPropellingTime()));
			
			array.add(object);
		}
		
		JSONObject object = new JSONObject();
		object.put("total",i);
		object.put("rows", array);
		return ArainResult.ok(object);
	}

	@Override
	public ArainResult update_01(SysUser user,ContentPropellingKey key, Integer action) {
		ContentPropelling propelling = contentPropellingMapper.selectByPrimaryKey(key);
		propelling.setIng(action);
		propelling.setAcceptTime(new Date());
		contentPropellingMapper.updateByPrimaryKey(propelling);
		if(action==2) {
			Content content = contentMapper.selectByPrimaryKey(key.getContentId());
			content.setId(null);
			content.setOrgid(user.getOrgid());
			contentMapper.insert(content);
		}
		return ArainResult.ok();
	}

	@Override
	public ArainResult load_see(SysUser user, ContentPropellingKey key) {
		ContentExample example = new ContentExample();
		example.createCriteria().andIdEqualTo(key.getContentId());
		List<Content> list = contentMapper.selectByExampleWithBLOBs(example);
		if(list!=null && list.size()>0) {
			return ArainResult.ok(list.get(0).getContent());
		}
		return ArainResult.ok();
	}

}
