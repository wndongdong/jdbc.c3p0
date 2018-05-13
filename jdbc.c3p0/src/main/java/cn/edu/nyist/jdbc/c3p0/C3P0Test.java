package cn.edu.nyist.jdbc.c3p0;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Test {
	
	private static Properties pro;
	private static ComboPooledDataSource cpds;
	static {
		//在类加载中获取properties文件中的内容
		pro=new Properties();//由于要在下面应用，则需定义成员变量
		try {
			pro.load(C3P0Test.class.getResourceAsStream("c3p0.properries"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws SQLException {
		//获取连接，这里从连接池中直接获取
		cpds=new ComboPooledDataSource();
		return cpds.getConnection();
	}
	
	public static void free() {
		cpds.close();
	}

}
