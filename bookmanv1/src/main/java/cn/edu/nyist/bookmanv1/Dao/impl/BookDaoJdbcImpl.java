package cn.edu.nyist.bookmanv1.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.edu.nyist.bookmanv1.Dao.BookDao;
import cn.edu.nyist.bookmanv1.util.JDBCUtil;
import cn.edu.nyist.bookmanv1.util.PageUtil;
import cn.edu.nyist.bookmanv1.vo.BookVo;
import cn.edu.nyist.bookmanv1.vo.TypeVo;


public class BookDaoJdbcImpl implements BookDao {

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

	@Override
	public List<TypeVo> getAllType() {
		Connection  conn=null;
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

	@Override
	public List<BookVo> getAllBooks(int pageNo, String name, int tid) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;	
		try {
			conn=JDBCUtil.getConn();
			String sql="select * from t_book where 1=1 ";
			if((name==null||name.equals(""))&&tid==1) {
				
			}else if((name==null||name.equals(""))&&tid!=1) {
				sql+="and tid="+tid;
			}else if(!(name==null||name.equals(""))&&tid==1){
				sql+="and name like %"+name+"%";
			}else {
				sql+="and name like %"+name+"% and tid="+tid;
			}
			sql+=" limit "+((pageNo-1)*PageUtil.PAGE_SIZE+1-1)+","+PageUtil.PAGE_SIZE;
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			List<BookVo> ls=new ArrayList<>();
			while(rs.next()) {
				BookVo bookVo=new BookVo();
				bookVo.setId(rs.getInt("id"));
				bookVo.setName(rs.getString("name"));
				bookVo.setDescri(rs.getString("descri"));
				bookVo.setAuthor(rs.getString("author"));
				bookVo.setPhoto(rs.getString("photo"));
				bookVo.setPubDate(rs.getDate("pubDate"));
				bookVo.setTid(rs.getInt("tid"));
				bookVo.setPrice(rs.getDouble("price"));
				ls.add(bookVo);
			}
			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.free(conn, stmt, rs);
		}
		return null;
	}

	@Override
	public int getTotal() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCUtil.getConn();
			stmt=conn.createStatement();
			String sql="select count(*) from t_book";
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.free(conn, stmt, rs);
		}
		return 0;
	}

}
