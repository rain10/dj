package org.zzd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
* <p>Title:KeyWordFilter </p>
* @author Arain
* @date2017年8月12日
 */
public class KeyWordFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		KeyWordRequest wordRequest = new KeyWordRequest((HttpServletRequest)request);
		chain.doFilter(wordRequest, response);
	}

	@Override
	public void destroy() {
	}

}
