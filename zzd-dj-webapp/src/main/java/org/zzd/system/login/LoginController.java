package org.zzd.system.login;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.common.util.AddressUtil;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysLog;
import org.zzd.pojo.SysUser;
import org.zzd.system.log.SysLogService;
import org.zzd.system.user.SysUserService;
/**
 * 
* <p>Title:SysLoginController </p>
* @author Arain
* @date2017年5月27日
 */
@Controller
@RequestMapping("system")
public class LoginController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysLogService sysLogService;
	
	@Value("${DEFAULIMG}")
	private String img;
	
	@RequestMapping("login")
	public String to_login(HttpServletRequest request)  {
		SysUser object = (SysUser) request.getSession().getAttribute("userInfo");
		if(object != null) {
			request.getSession().removeAttribute("userInfo");
		}
		return "system/login/login";
	}
	
	
	@RequestMapping("login/login.do")
	@ResponseBody
	public ArainResult login(SysUser user,String valiDate,HttpServletRequest request) {
		String object = (String) request.getSession().getAttribute("rand");
		if(object.equalsIgnoreCase(valiDate)) {
			ArainResult result = sysUserService.load_login(user);
			SysUser sysUser = (SysUser) result.getData();
			if(sysUser != null) {
				if(StringUtils.isBlank(sysUser.getPrphone())) {
					sysUser.setPrphone(img);
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", sysUser);
			session.setMaxInactiveInterval(30*60);
			
			InetAddress address;
			try {
				address = InetAddress.getLocalHost();
				String ua = request.getHeader("User-Agent");
				SysLog log = new SysLog();
				log.setMac(ua);//System.getProperty("os.name" )
				log.setIp(AddressUtil.getIpAddr(request));
				
				sysLogService.save_01(sysUser,log);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			return result;
		}
		return ArainResult.build(203, "验证码错误！");
	}
	
	@RequestMapping("login/logout.do")
	@ResponseBody
	public ArainResult logout(HttpServletRequest request) {
		request.getSession().removeAttribute("userInfo");
		return ArainResult.ok();
	}
}
