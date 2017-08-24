package org.zzd.common.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthImage extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;
	
	@RequestMapping("image")
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		System.out.println(verifyCode);
		// 存入会话session
		HttpSession session = request.getSession(true);
		session.setAttribute("rand", verifyCode.toLowerCase());
		// 生成图片
		int w = 100, h = 40;
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

	}
}
