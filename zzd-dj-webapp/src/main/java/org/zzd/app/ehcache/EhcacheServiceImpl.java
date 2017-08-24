package org.zzd.app.ehcache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zzd.mapper.ContentPropellingMapper;
import org.zzd.mapper.ExaminationMapper;
import org.zzd.pojo.ContentPropelling;
import org.zzd.pojo.ContentPropellingExample;
import org.zzd.pojo.Examination;
import org.zzd.pojo.ExaminationExample;

/**
 * 
* <p>Title:EhcacheServiceImpl </p>
* @author Arain
* @date2017年8月11日
 */
@Service
public class EhcacheServiceImpl implements EhcacheService{
	@Autowired
	private ExaminationMapper mapper;
	@Autowired
	private ContentPropellingMapper contentPropellingMapper;
	@Override
	@Cacheable(cacheNames="examcache")
	public List<Examination> load_list() {
		ExaminationExample example = new ExaminationExample();
		example.createCriteria().andTypeNotEqualTo(2);
		List<Examination> list = mapper.selectByExample(example);
		return list;
	}
	@Override
	@Cacheable(cacheNames="contentcache")
	public List<ContentPropelling> load_list_propelling() {
		ContentPropellingExample example = new ContentPropellingExample();
		example.createCriteria().andIngEqualTo(0);
		List<ContentPropelling> list = contentPropellingMapper.selectByExample(example);
		return list;
	}

}
