package cn.edu.nyist.bookmanv1.biz.impl;

import java.util.List;

import cn.edu.nyist.bookmanv1.Dao.BookAllTypeDao;
import cn.edu.nyist.bookmanv1.Dao.impl.BookAllTypeJdbcDaoImpl;
import cn.edu.nyist.bookmanv1.biz.BookTypeBiz;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

public class BookTypeBizImpl implements BookTypeBiz {

	@Override
	public List<TypeVo> getAllType() {
		BookAllTypeDao allType=new BookAllTypeJdbcDaoImpl();
		return allType.getAllType();
	}

}
