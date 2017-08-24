package org.zzd.app.study;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.Content;
import org.zzd.pojo.SysUser;

public interface StudyService {
ArainResult load_grid(int page, int rows, String sort,String order,String title,Integer type,SysUser user);
	
	ArainResult save_01(Content content,String[] imageId);
	
	ArainResult load_01(Content content);

}
