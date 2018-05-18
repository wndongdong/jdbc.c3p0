package cn.edu.nyist.bookmanv1.biz.impl;

import java.util.List;

import cn.edu.nyist.bookmanv1.Dao.BookTypeDao;
import cn.edu.nyist.bookmanv1.Dao.impl.BookTypeJdbcDaoImpl;
import cn.edu.nyist.bookmanv1.biz.BookTypeBiz;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

public class BookTypeBizImpl implements BookTypeBiz {

	@Override
	public List<TypeVo> getAllType() {
		BookTypeDao bookTypeDao=new BookTypeJdbcDaoImpl();
		return bookTypeDao.getAllType();
	}

}
