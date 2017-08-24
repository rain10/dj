package org.zzd.app.study;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.DictUtil;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.ContentAttachmentsMapper;
import org.zzd.mapper.ContentMapper;
import org.zzd.mapper.SysAttachmentsMapper;
import org.zzd.pojo.Content;
import org.zzd.pojo.ContentAttachmentsExample;
import org.zzd.pojo.ContentAttachmentsKey;
import org.zzd.pojo.ContentExample;
import org.zzd.pojo.SysAttachments;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.ContentExample.Criteria;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
/**
 * 
* <p>Title:StudyServiceImpl </p>
* @author Arain
* @date2017年8月7日
 */
@Service
public class StudyServiceImpl implements StudyService{
	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private ContentAttachmentsMapper contentAttachmentsMapper;
	@Autowired
	private SysAttachmentsMapper sysAttachmentsMapper;
	
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
}
