package org.zzd.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.zzd.app.ehcache.EhcacheService;
import org.zzd.system.keyword.KeyWordService;
@Component
public class Application implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private EhcacheService ehcacheService;
	@Autowired
	private KeyWordService keyWordService;
	@Override
	@CacheEvict(value="examcache",allEntries=true,beforeInvocation=true)
	public void onApplicationEvent(ContextRefreshedEvent event) {
		 keyWordService.load_list();
		 ehcacheService.load_list();
	}
}
