package org.zzd.system.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.zzd.common.util.ArainResult;

import com.mysql.jdbc.Connection;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 
* <p>Title:DataServiceImpl </p>
* @author Arain
* @date2017年8月1日
 */
@Service
public class DataServiceImpl implements DataService{
	 private final String DRIVER = "com.mysql.jdbc.Driver";
	 private final String URL = "jdbc:mysql://localhost:3306/dj";
	 private final String USERNAME = "root";
	 private final String PASSWORD = "root";
	@Override
	public  ArainResult exportDatabaseTool(String hostIP, String userName, String password, String savePath, String fileName, String databaseName) throws InterruptedException {  
        File saveFile = new File(savePath);  
        if (!saveFile.exists()) {// 如果目录不存在  
            saveFile.mkdirs();// 创建文件夹  
        }  
        if(!savePath.endsWith(File.separator)){  
            savePath = savePath + File.separator;  
        }  
          
        PrintWriter printWriter = null;  
        BufferedReader bufferedReader = null;  
        try {  
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));  
            Process process = Runtime.getRuntime().exec(" mysqldump -h" + hostIP + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName);  
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");  
            bufferedReader = new BufferedReader(inputStreamReader);  
            String line;  
            while((line = bufferedReader.readLine())!= null){  
                printWriter.println(line);  
            }  
            printWriter.flush();  
            if(process.waitFor() == 0){//0 表示线程正常终止。  
                return ArainResult.ok();  
            }  
        }catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (bufferedReader != null) {  
                    bufferedReader.close();  
                }  
                if (printWriter != null) {  
                    printWriter.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return ArainResult.build(400, "系统异常");  
    }

	@Override
	public ArainResult load_mysql() throws Exception {
		    
		        Class.forName(DRIVER);
		        Connection con = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
		        DatabaseMetaData metaData = (DatabaseMetaData) con.getMetaData();
		        
		        /**
		         * 1.返回数据库的相关信息
		         */
		         System.out.println("数据库已知的用户: "+ metaData.getUserName());   
		         System.out.println("数据库的系统函数的逗号分隔列表: "+ metaData.getSystemFunctions());   
		         System.out.println("数据库的时间和日期函数的逗号分隔列表: "+ metaData.getTimeDateFunctions());   
		         System.out.println("数据库的字符串函数的逗号分隔列表: "+ metaData.getStringFunctions());   
		         System.out.println("数据库供应商用于 'schema' 的首选术语: "+ metaData.getSchemaTerm());   
		         System.out.println("数据库URL: " + metaData.getURL());   
		         System.out.println("是否允许只读:" + metaData.isReadOnly());   
		         System.out.println("数据库的产品名称:" + metaData.getDatabaseProductName());   
		         System.out.println("数据库的版本:" + metaData.getDatabaseProductVersion());   
		         System.out.println("驱动程序的名称:" + metaData.getDriverName());   
		         System.out.println("驱动程序的版本:" + metaData.getDriverVersion()); 
		         System.out.println();   
		         System.out.println("数据库中使用的表类型"); 
		         
		         JSONObject object = new JSONObject();
		         object.accumulate("UserName", metaData.getUserName());
		         object.accumulate("URL", metaData.getURL());
		         object.accumulate("ProductName", metaData.getDatabaseProductName());
		         object.accumulate("ProductVersion", metaData.getDatabaseProductVersion());
		         object.accumulate("Version",metaData.getDriverVersion());
		         
		         ResultSet rs = metaData.getTableTypes();   
		         while (rs.next()) {   
		             System.out.println("1.-->"+rs.getString(1));  
		         }   
		         rs.close();   
		         System.out.println();
		         
		         /**  
		          * 获取指定的数据库的所有表的类型,getTables()的第一个参数就是数据库名  
		          * 因为与MySQL连接时没有指定,这里加上,剩下的参数就可以为null了  
		          * 第二个参数是模式名称的模式,但是输出也是什么都没有。
		          */  
		         ResultSet rs1 = metaData.getTables(null,"dj",null, null);   
		         object.accumulate("tableName","dj");
		         while (rs1.next()) {   
		             System.out.println();   
		             System.out.println("数据库名:"+ rs1.getString(1));   
		             System.out.println("表名: "+rs1.getString(3));   
		             System.out.println("类型: "+rs1.getString(4));   
		             
		         }   
		         rs1.close();   
		         
		         JSONArray array = new JSONArray();
		         array.add(object);
		         JSONObject  out = new JSONObject();
		         out.accumulate("total",array.size());
		 		 out.accumulate("rows",array);
		         return ArainResult.ok(out);   
//		         System.out.println();   
//		         System.out.println("获取指定的数据库的表的主键");   
//		         //获取指定的数据库的表的主键，第二个参数也是模式名称的模式,使用null了   第三个是表名称  为null表示可以查到所有的表
//		         ResultSet rs2 = metaData.getPrimaryKeys("wxfirst", null, "materialinfo");   
//		         
//		         while (rs2.next()) {   
//		             System.out.println("表名称: "+ rs2.getString(3));   
//		             System.out.println("主键名称: "+ rs2.getString(4));   
//		             System.out.println("主键de序列号: "+ rs2.getString(5));   
//		             System.out.println("主键de名称: "+ rs2.getString(6));   
//		         }   
//		         rs2.close();   
//		            
//		         System.out.println(); 
//		         
//		         
//		         /**
//		          * 获取某个表的索引信息
//		          */
//		         System.out.println("DatabaseMetaData.getIndexInfo()方法返回信息:");   
//		         ResultSet rs3 = metaData.getIndexInfo("wxfirst", null, "materialinfo", false, true);   
//		         while (rs3.next()) {   
//		             System.out.println("数据库名: "+ rs3.getString(1));   
//		             System.out.println("表模式: "+ rs3.getString(2));   
//		             System.out.println("表名称: "+ rs3.getString(3));   
//		             System.out.println("索引值是否可以不唯一: "+ rs3.getString(4));   
//		             System.out.println("索引类别: "+ rs3.getString(5));   
//		             System.out.println("索引名称: "+ rs3.getString(6));   
//		             System.out.println("索引类型: "+ rs3.getString(7));   
//		             System.out.println("索引中的列序列号: "+ rs3.getString(8));   
//		             System.out.println("列名称: "+ rs3.getString(9));   
//		             System.out.println("列排序序列: "+ rs3.getString(10));   
//		             System.out.println("TYPE为 tableIndexStatistic时它是表中的行数否则它是索引中唯一值的数量: "+ rs3.getString(11));   
//		             System.out.println("TYPE为 tableIndexStatisic时它是用于表的页数否则它是用于当前索引的页数: "+ rs3.getString(12));   
//		             System.out.println("过滤器条件: "+ rs3.getString(13));   
//		         }   
//		         rs3.close();
//		         
//		         
//		         System.out.println(); 
//		         
//		         /**
//		          * 获取某个表的所有列信息
//		          */
//		         System.out.println("DatabaseMetaData.getColumns()方法返回数据表列信息");
//		         ResultSet rs4 = metaData.getColumns("wxfirst", null, "materialinfo", "mediaType");
//		         while(rs4.next()){
//		             System.out.println("数据库名称:"+rs4.getString(1));
//		             System.out.println("表模式:"+rs4.getString(2));
//		             System.out.println("表名称:"+rs4.getString(3));
//		             System.out.println("列名称:"+rs4.getString(4));
//		             System.out.println("SQL类型:"+rs4.getString(5));
//		             System.out.println("数据源依赖类型名称:"+rs4.getString(6));
//		             System.out.println("列的大小:"+rs4.getString(7));
//		             System.out.println("未被使用:"+rs4.getString(8));
//		             System.out.println("小数部分的位数:"+rs4.getString(9));
//		             System.out.println("基数:"+rs4.getString(10));
//		             System.out.println("是否允许NULL:"+rs4.getString(11));
//		             System.out.println("描述列的注释:"+rs4.getString(12));
//		             System.out.println("该列的默认值:"+rs4.getString(13));
//		             System.out.println("未使用:"+rs4.getString(14));
//		             System.out.println("未使用:"+rs4.getString(15));
//		             System.out.println("对于char类型， 该长度是列中的最大字节数:"+rs4.getString(16));
//		             System.out.println("表中列的索引:"+rs4.getString(17));
//		             System.out.println("ISO规则用于确定列是否包括NULL:"+rs4.getString(18));
//		             System.out.println("表的类别:"+rs4.getString(19));
//		             System.out.println("表的模式:"+rs4.getString(20));
//		             System.out.println("表名称:"+rs4.getString(21));
//		             System.out.println("不同类型或用户生成Ref类型:"+rs4.getString(22));
//		             System.out.println("此列是否自增:"+rs4.getString(23));
//		         }
//		         rs4.close();
		         
		         
		         
		         
		}    
}
