package org.zzd.common.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.zzd.pojo.SysUser;
import org.zzd.system.user.SysUserService;

@Controller
public class UploadFile {
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("/images/upload")
	@ResponseBody
	public UploadResult upload(final MultipartHttpServletRequest request, HttpServletRequest request2)
			throws UnsupportedEncodingException {
		SysUser user = (SysUser) request2.getSession().getAttribute("userInfo");

		UploadResult result = new UploadResult();

		request.setCharacterEncoding("utf-8");
		MultipartFile uploadFile = request.getFile("image");
		
		if (uploadFile != null) {
			String picName = uploadFile.getOriginalFilename();
			String path = "/admin/img/";
			String url = request.getSession().getServletContext().getRealPath(path) + "/";

			if (uploadFile != null && uploadFile.getSize() > 0) {

				String newPic = IDUtil.genImageName() + picName.substring(picName.lastIndexOf("."));

				File file = new File(url + newPic);
				try {
					uploadFile.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				url = path + newPic;
				result = new UploadResult(0, url, "上传成功",file.getPath());

				sysUserService.save_image(user, url);

				return result;
			}
		}
		result.setCode(1);
		result.setMessage("上传失败！");
		return result;

	}

//	@RequestMapping("uploadImage")
//	@ResponseBody // 这里upfile是config.json中图片提交的表单名称
//	public Map<String, String> uploadImage(@RequestParam("upfile") CommonsMultipartFile upfile,
//			HttpServletRequest request) throws IOException {
//
//		// 文件原名称
//
//		String fileName = upfile.getOriginalFilename();
//
//		// 为了避免重复简单处理
//		String nowName = new Date().getTime() + "_" + fileName;
//		
//		if (!upimage.isEmpty()) {
//
//			// 上传位置路径
//
//			String path0 = "D:\\eclipseworkspace\\maven-web\\src\\main\\webapp\\upload\\" + nowName;
//
//			// 按照路径新建文件
//
//			File newFile = new File(path0);
//
//			// 复制
//
//			FileCopyUtils.copy(upimage.getBytes(), newFile);
//
//		}
//
//		// 返回结果信息(UEditor需要)
//
//		Map<String, String> map = new HashMap<String, String>();
//
//		// 是否上传成功
//
//		map.put("state", "SUCCESS");
//
//		// 现在文件名称
//
//		map.put("title", nowName);
//
//		// 文件原名称
//
//		map.put("original", fileName);
//
//		// 文件类型 .+后缀名
//
//		map.put("type", fileName.substring(upfile.getOriginalFilename().lastIndexOf(".")));
//
//		// 文件路径
//
//		map.put("url", "/" + nowName + "/getImage.do");
//
//		// 文件大小（字节数）
//
//		map.put("size", upfile.getSize() + "");
//
//		return map;
//
//	}
}
