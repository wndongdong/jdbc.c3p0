package cn.edu.nyist.jdbc.c3p0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectData {

	public static void main(String[] args) throws SQLException {
		//要求：查询数据库中的t_user表的内容
		
		
		//1.获取连接
		Connection conn=C3P0Test.getConn();
		//2.到数据库进行查询
		String sql="select * from t_user";
		Statement stmt=conn.createStatement();
		//3.返回查询结果
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd=rs.getMetaData();
		for (int i = 1; i < rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnName(i)+"\t\t");
		}
		while(rs.next()) {
			for (int i = 1; i < rsmd.getColumnCount(); i++) {
				System.out.println(rs.getObject(i)+"\t\t");
			}
		}
		C3P0Test.free();
	}

}
