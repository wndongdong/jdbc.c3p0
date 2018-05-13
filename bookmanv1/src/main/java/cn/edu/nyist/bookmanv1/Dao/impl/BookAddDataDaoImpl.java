package cn.edu.nyist.bookmanv1.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import cn.edu.nyist.bookmanv1.Dao.BookAddDataDao;
import cn.edu.nyist.bookmanv1.util.JDBCUtil;


public class BookAddDataDaoImpl implements BookAddDataDao {

	@Override
	public int getAdd(String name, String descri, String author, int tid, Date pubDate, double price,
			String photo) {
		Connection conn=null;
		PreparedStatement stmt = null;
		try {
			conn=JDBCUtil.getConn();
			String sql="insert into t_book(name,descri,author,tid,pubDate,price,photo) values (?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, name);
			stmt.setString(2, descri);
			stmt.setString(3, author);
			stmt.setInt(4, tid);
			stmt.setDate(5,new java.sql.Date(pubDate.getTime()));
			stmt.setDouble(6, price);
			stmt.setString(7, photo);
			int ret=stmt.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.free(conn, stmt);
		}
		return 0;
	}

}
