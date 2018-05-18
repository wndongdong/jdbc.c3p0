package cn.edu.nyist.bookmanv1.Dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nyist.bookmanv1.Dao.BookTypeDao;
import cn.edu.nyist.bookmanv1.util.JDBCUtil;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

public class BookTypeJdbcDaoImpl implements BookTypeDao {

	@Override
	public List<TypeVo> getAllType() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtil.getConn();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from t_booktype");
			List<TypeVo> ls=new ArrayList<>();
			while(rs.next()) {
				TypeVo typeVo=new TypeVo();
				typeVo.setId(rs.getInt("id"));
				typeVo.setName(rs.getString("name"));
				ls.add(typeVo);
			}
			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.free(conn, stmt, rs);
		}
		return null;
	}

}
