package org.zzd.system.common;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zzd.app.content.ContentService;
import org.zzd.app.exam.ExamService;
import org.zzd.common.pojo.MessgePojo;
import org.zzd.common.util.AddressUtil;
import org.zzd.common.util.ArainResult;
import org.zzd.pojo.SysLog;
import org.zzd.pojo.SysUser;
import org.zzd.pojo.SysUserQuick;
import org.zzd.pojo.SysUserQuickKey;
import org.zzd.system.log.SysLogService;
import org.zzd.system.quick.QuickService;

import net.sf.json.JSONObject;

@Controller
public class ErrorAndOtherController {
	@Autowired
	private SysLogService logService;
	@Autowired
	private ContentService contentService;
	@Autowired
	private ExamService examService;

	@Autowired
	private QuickService quickService;

	@RequestMapping("/system/index_statistics")
	public String dome() {
		return "system/index";
	}

	@RequestMapping("error")
	public String error() {
		return "system/error";
	}

	@RequestMapping("login_timeout")
	public String login_timeout() {
		return "system/error_login";
	}

	@RequestMapping("messges.do")
	@ResponseBody
	public ArainResult load_messges(HttpServletRequest request) {
		SysUser object = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = logService.load_safe(object);
		MessgePojo messgePojo = new MessgePojo();
		SysLog data = (SysLog) result.getData();
		try {
			JSONObject addresses = AddressUtil.getAddresses("ip=" + data.getIp(), "utf-8");
			if (addresses.get("msg") != null) {
				messgePojo.settLastAddress((String) addresses.get("country") + (String) addresses.get("region") + "/"
						+ (String) addresses.get("city"));
				messgePojo.settLastIp(data.getIp());
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ArainResult.ok(messgePojo);
	}

	@RequestMapping("/system/error")
	public String load_404() {
		return "system/404";
	}

	@RequestMapping("content/count")
	@ResponseBody
	public ArainResult load_content_count(HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = contentService.load_all_count(user);
		return result;
	}

	@RequestMapping("content/type")
	@ResponseBody
	public ArainResult load_content_type(HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = contentService.load_all_type(user);
		return result;
	}

	@RequestMapping("exam/statistics")
	@ResponseBody
	public ArainResult exam_statistics(HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = examService.load_exam_user(user);
		return result;
	}

	@RequestMapping("send_messges.do")
	@ResponseBody
	public ArainResult load_send(HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = contentService.load_send(user);
		return result;
	}

	@RequestMapping("/meun/quick_meun.do")
	@ResponseBody
	public ArainResult save_quick(SysUserQuickKey quickKey, HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = quickService.save_01(quickKey, user);
		return result;
	}

	@RequestMapping("/meun/quick_meun_check.do")
	@ResponseBody
	public ArainResult check_quick(SysUserQuickKey quickKey, HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = quickService.load_01(quickKey, user);
		return result;
	}
	
	@RequestMapping("/meun/delete_quick_meun.do")
	@ResponseBody
	public ArainResult delete_quick(SysUserQuickKey quickKey, HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = quickService.delete_01(quickKey, user);
		return result;
	}
	
	@RequestMapping("/meun/load_quick_meun.do")
	@ResponseBody
	public ArainResult laod_quick(SysUserQuickKey quickKey, HttpServletRequest request) {
		SysUser user = (SysUser) request.getSession().getAttribute("userInfo");
		ArainResult result = quickService.load_list(user);
		return result;
	}
}
