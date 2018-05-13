package cn.edu.nyist.bookmanv1.biz.impl;

import java.sql.ResultSet;

import cn.edu.nyist.bookmanv1.Dao.SelectBookType;
import cn.edu.nyist.bookmanv1.Dao.impl.SelectBookTypeImpl;
import cn.edu.nyist.bookmanv1.biz.BookTypeBiz;

public class BookTypeBizImpl implements BookTypeBiz {

	@Override
	public ResultSet getBookType() {
		SelectBookType sbt=new SelectBookTypeImpl();
		return sbt.getBookType();
	}

}
