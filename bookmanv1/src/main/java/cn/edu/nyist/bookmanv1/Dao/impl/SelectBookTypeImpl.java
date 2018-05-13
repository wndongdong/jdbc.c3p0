package cn.edu.nyist.bookmanv1.Dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.nyist.bookmanv1.Dao.SelectBookType;
import cn.edu.nyist.bookmanv1.util.JDBCUtil;

public class SelectBookTypeImpl implements SelectBookType {

	@Override
	public  ResultSet getBookType() {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn=JDBCUtil.getConn();
			String sql="select * from t_book_type";
			stmt=conn.createStatement();
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.free(conn, stmt);
		}
		return null;
	}

	
}
