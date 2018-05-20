package cn.edu.nyist.bookmanv1.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cn.edu.nyist.bookmanv1.Dao.LoginDao;
import cn.edu.nyist.bookmanv1.util.JDBCUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean getRet(String name, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean ret = false;
		try {
			conn=JDBCUtil.getConn();
			String sql="select * from t_book_useman where name=? and pwd=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			rs=stmt.executeQuery();
			ret=rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.free(conn, stmt, rs);
		}
		return ret;
	}

}
