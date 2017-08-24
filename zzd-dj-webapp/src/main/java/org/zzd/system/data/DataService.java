package org.zzd.system.data;

import java.sql.SQLException;

import org.zzd.common.util.ArainResult;

public interface DataService {
	public  ArainResult exportDatabaseTool(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) throws InterruptedException;
	
	ArainResult load_mysql() throws Exception;
}
