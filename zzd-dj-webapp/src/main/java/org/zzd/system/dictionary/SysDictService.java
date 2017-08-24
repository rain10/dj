package org.zzd.system.dictionary;

import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysDictionary;

public interface SysDictService {
	public String load_datagrid(int page,int rows,Integer enable,String name,String type,String sort);
	public ArainResult save_01(SysDictionary sysDictionary,String actionType);
	public ArainResult load_01(SysDictionary sysDictionary);
	
}
