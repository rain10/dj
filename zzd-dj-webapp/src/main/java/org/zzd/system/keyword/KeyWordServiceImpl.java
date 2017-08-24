package org.zzd.system.keyword;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zzd.mapper.SysKeywordMapper;
import org.zzd.pojo.SysKeyword;
import org.zzd.pojo.SysKeywordExample;

/**
 * 
* <p>Title:KeyWordServiceImpl </p>
* @author Arain
* @date2017年8月12日
 */
@Service
public class KeyWordServiceImpl implements KeyWordService{
	@Autowired
	private SysKeywordMapper keywordMapper;

	@Cacheable(cacheNames="keywordcache")
	@Override
	public List<SysKeyword> load_list() {
		SysKeywordExample example = new SysKeywordExample();
		List<SysKeyword> list = keywordMapper.selectByExample(example);
		return list;
	}
	
}
