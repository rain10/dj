package org.zzd.common.util;

/**
 * 文件上传工具类
 * 
 * @author Arain
 * 
 */
public class UploadResult {

	/**
	 * 上传图片返回值，成功：0 失败：1
	 */
	private Integer code;
	/**
	 * 回显图片使用的url
	 */
	private String url;
	/**
	 * 错误时的错误消息
	 */
	private String message;
	
	private String id;
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UploadResult(Integer code, String url, String message, String id) {
		super();
		this.code = code;
		this.url = url;
		this.message = message;
		this.id = id;
	}

	public UploadResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
