package org.zzd.common.util;

import org.zzd.common.pojo.CommonContains;

/**
 * ueditor工具类
 * 
 * @author linjw
 *
 */
public class SystemUtil {
	
	/**
	 * 是否修改ueditor保存文件路径
	 * @return
	 */
	public static boolean isUpdatePath(){
		return CommonContains.IS_UPDATE_PATH;
	}
	/**
	 * 获取存放文件的根目录
	 * 
	 * @return
	 */
	public static String getRootPath() {
		return getRoot()+"/"+getAppName()+"-files";
	}

	/**
	 * 获取加载磁盘文件controller方法路径
	 * 
	 * @return
	 */
	public static String getLoadUrl() {
		return CommonContains.DOWNLOAD_URL;
	}
	
	/**
	 * 获取项目目录
	 * @return
	 */
	private static String getDir(){
		return System.getProperty("user.dir").replace( "\\", "/" );
	}
	
	/**
	 * 获取项目名称
	 * @return
	 */
	private static String getAppName(){
		String[] dirs=getDir().split("/");
		return dirs[dirs.length-1];
	}
	/**
	 * 获取项目根
	 * @return
	 */
	private static String getRoot(){
		String[] dirs=getDir().split("/");
		return dirs[0];
	}
}
