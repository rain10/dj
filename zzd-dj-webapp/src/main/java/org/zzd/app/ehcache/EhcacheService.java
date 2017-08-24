package org.zzd.app.ehcache;

import java.util.List;

import org.zzd.pojo.ContentPropelling;
import org.zzd.pojo.Examination;

public interface EhcacheService {
	List<Examination> load_list();
	
	List<ContentPropelling> load_list_propelling();
}
