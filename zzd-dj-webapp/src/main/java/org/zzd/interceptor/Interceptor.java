package org.zzd.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zzd.common.util.AddressUtil;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysLogHandle;
import org.zzd.pojo.SysUser;
import org.zzd.system.handle.SysLogHandleService;
import org.zzd.system.user.SysUserService;

import net.sf.json.JSONObject;
/**
 * 
* <p>Title:Interceptor </p>
* @author Arain
* @date2017年6月6日
 */
@Controller
public class Interceptor extends HandlerInterceptorAdapter{
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysLogHandleService sysLogHandleService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		if(user == null) {
			request.getRequestDispatcher("/login_timeout").forward(request, response);
			return false;
		}
		
		String uri = request.getRequestURI();
		if(uri.equals("/container")) {
			return true;
		}
		
		ArainResult result = sysUserService.load_shiro(uri, user);
		if (result.getStatus() == 400) {
			request.getRequestDispatcher("/error").forward(request, response);
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		
		System.out.println(ex);
		String uri = request.getRequestURI();
		String url = "/system/loghandle/load_datagrid.do";
		String url2= "/app/content/";
		if (url.equals(uri)) { return; }
		
		if(uri.contains(url2)) { return; }
		
		JSONObject object = new JSONObject();
		Enumeration<?> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement().toString();
			object.accumulate(name, request.getParameter(name));
		}
		
		SysLogHandle handle = new SysLogHandle();
		handle.setLogData(object.toString());
		handle.setLogUser(user.getRealname());
		handle.setLogUrl(uri);
		handle.setLogIp(AddressUtil.getIpAddr(request));
		if(ex != null) {
			handle.setLogException(ex.getMessage());
			handle.setLogSuccess("0");
		} else {
			handle.setLogException("ok");
			handle.setLogSuccess("1");
		}
		
		sysLogHandleService.save_01(handle);
		super.afterCompletion(request, response, handler, ex);
	}

}
