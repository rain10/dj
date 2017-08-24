package org.zzd.app.content;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.Content;
import org.zzd.pojo.ContentPropelling;
import org.zzd.pojo.ContentPropellingKey;
import org.zzd.pojo.SysUser;

public interface ContentService {
	
	ArainResult load_grid(int page, int rows, String sort,String order,String title,Integer type,SysUser user);
	
	ArainResult save_01(Content content,String[] imageId);
	
	ArainResult load_01(Content content);
	
	ArainResult load_all_count(SysUser user);

	ArainResult load_all_type(SysUser user);
	
	ArainResult save_send(String propellingTime,ContentPropellingKey key);
	
	ArainResult load_send(SysUser user);
	
	ArainResult update_01(SysUser user,ContentPropellingKey key,Integer action);
	
	ArainResult load_see(SysUser user,ContentPropellingKey key);
}
