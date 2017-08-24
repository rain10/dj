package org.zzd.system.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zzd.common.pojo.FilePojo;
import org.zzd.common.util.ArainResult;
import org.zzd.common.util.JsonUtils;
import org.zzd.mapper.ContentAttachmentsMapper;
import org.zzd.mapper.SysAttachmentsMapper;
import org.zzd.pojo.ContentAttachmentsExample;
import org.zzd.pojo.ContentAttachmentsKey;
import org.zzd.pojo.SysAttachments;

import com.alibaba.fastjson.JSONArray;

@RestController
public class LoadFileController {
	@Autowired
	private SysAttachmentsMapper sysAttachmentsMapper;
	@Autowired
	private ContentAttachmentsMapper contentAttachmentsMapper;
	@RequestMapping("/app/content/load_news_img")
	public ArainResult load_image(String id) {
		ContentAttachmentsExample example =new ContentAttachmentsExample();
		example.createCriteria().andContentIdEqualTo(Long.valueOf(id));
		List<ContentAttachmentsKey> list = contentAttachmentsMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			JSONArray array = new JSONArray();
			for (ContentAttachmentsKey contentAttachmentsKey : list) {
				FilePojo pojo = new FilePojo();
				SysAttachments sysAttachments = sysAttachmentsMapper.selectByPrimaryKey(contentAttachmentsKey.getAttachmentsId());
				pojo.setUrl(sysAttachments.getServicePath()+sysAttachments.getAppName()+sysAttachments.getAttachmentPath());
				pojo.setSize(Long.valueOf(sysAttachments.getAttachmentSize()));
				pojo.setName(sysAttachments.getAttachmentName());
				pojo.setId(sysAttachments.getId());
				
				array.add(pojo);
			}
			
			return ArainResult.ok(array);
		}
		
		return ArainResult.ok();
	}
}
