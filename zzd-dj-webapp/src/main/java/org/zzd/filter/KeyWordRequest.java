package org.zzd.filter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.zzd.pojo.SysKeyword;
import org.zzd.system.keyword.KeyWordService;

public class KeyWordRequest extends HttpServletRequestWrapper {

	public KeyWordRequest(HttpServletRequest request) {
		super(request);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String[]> getParameterMap() {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		KeyWordService service = wac.getBean(KeyWordService.class);
		List<SysKeyword> list = service.load_list();
		Map<String, String[]> paramMap = super.getParameterMap();
		if(paramMap!=null) {
			for (String[] values : paramMap.values()) {
				for (int i = 0; i < values.length; i++) {
					for (SysKeyword sysKeyword : list) {
						values[i] = values[i].replace(sysKeyword.getKeyword(), "*");
					}
				}
			}
		}
		
		return paramMap;
	}

	@Override
	public String getParameter(String name) {
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		KeyWordService service = wac.getBean(KeyWordService.class);
		String parameter = super.getParameter(name);
		List<SysKeyword> list = service.load_list();
		for (SysKeyword sysKeyword : list) {
			if (StringUtils.isNotBlank(parameter)) {
				parameter = parameter.replace(sysKeyword.getKeyword(), "*");
			}
		}
		return parameter;
	}
}
