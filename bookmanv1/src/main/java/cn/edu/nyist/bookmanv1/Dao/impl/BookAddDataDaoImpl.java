package cn.edu.nyist.bookmanv1.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import cn.edu.nyist.bookmanv1.Dao.BookAddDataDao;
import cn.edu.nyist.bookmanv1.util.JDBCUtil;
import cn.edu.nyist.bookmanv1.vo.BookVo;


public class BookAddDataDaoImpl implements BookAddDataDao {

	@Override
	public int getAdd(BookVo bookVo) {
		Connection conn=null; 
		PreparedStatement stmt = null;
		try {
			conn=JDBCUtil.getConn();
			String sql="insert into t_book(name,descri,author,tid,pubDate,price,photo) values (?,?,?,?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			
			stmt.setString(1, bookVo.getName());
			stmt.setString(2, bookVo.getDescri());
			stmt.setString(3, bookVo.getAuthor());
			stmt.setInt(4, bookVo.getTid());
			stmt.setDate(5,new java.sql.Date(bookVo.getPubDate().getTime()));
			stmt.setDouble(6,bookVo.getPrice());
			stmt.setString(7, bookVo.getPhoto());
			System.out.println(bookVo.getTid());
			
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
