package org.zzd.app.quartz;

import java.util.List;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.zzd.app.ehcache.EhcacheService;
import org.zzd.common.util.TimeUtil;
import org.zzd.mapper.ContentPropellingMapper;
import org.zzd.mapper.ExaminationMapper;
import org.zzd.pojo.ContentPropelling;
import org.zzd.pojo.Examination;
/**
 * 
* <p>Title:ExamQuartzServiceImpl </p>
* @author Arain
* @date2017年8月14日
 */
public class ExamQuartzServiceImpl implements  ExamQuartzService{
	
	@Override
	public void save_execute() {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		ExaminationMapper mapper = wac.getBean(ExaminationMapper.class);
		EhcacheService ehcacheService = wac.getBean(EhcacheService.class);
		ContentPropellingMapper propellingMapper = wac.getBean(ContentPropellingMapper.class);
		String now = TimeUtil.getNow(TimeUtil.FORMAT_INT);
//		System.out.println("Examination system timing task execution："+TimeUtil.getNow()+"  ｡:.ﾟヽ(｡◕‿◕｡)ﾉﾟ.:｡+ﾟ");
//		ExaminationExample example = new ExaminationExample();
//		example.createCriteria().andTypeNotEqualTo(2);
//		List<Examination> list = mapper.selectByExample(example);
		List<Examination> list = ehcacheService.load_list();
		if(list!=null && list.size()>0) {
			for (Examination examination : list) {
				if(examination.getIng()==0) {
					String start = TimeUtil.format(examination.getStartTime(), TimeUtil.FORMAT_INT);
					if(now.equals(start)) {
						examination.setIng(1);
						mapper.updateByPrimaryKey(examination);
					}
				} 
				if(examination.getIng()==1) {
					
					String end = TimeUtil.format(examination.getEndTime(), TimeUtil.FORMAT_INT);
					if(now.equals(end)) {
						examination.setIng(2);
						mapper.updateByPrimaryKey(examination);
					}
				}
			}
		}
		
		List<ContentPropelling> list_propelling = ehcacheService.load_list_propelling();
		if(list_propelling!=null && list_propelling.size()>0) {
			for (ContentPropelling contentPropelling : list_propelling) {
				String start = TimeUtil.format(contentPropelling.getPropellingTime(), TimeUtil.FORMAT_INT);
				if(now.equals(start)) {
					contentPropelling.setIng(1);
					propellingMapper.updateByPrimaryKey(contentPropelling);
				}
			}
		}
	}
}
