package org.zzd.system.data;

public class DataPojo {
	private String hostIP = "127.0.0.1";
	private String userName = "root";
	private String password = "root";
	private String savePath = "c:/backup/";
	private String fileName = "backup.sql";
	private String databaseName = "dj";
	public String getHostIP() {
		return hostIP;
	}
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDatabaseName() {
		return databaseName;
	}
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}
	
	
}
