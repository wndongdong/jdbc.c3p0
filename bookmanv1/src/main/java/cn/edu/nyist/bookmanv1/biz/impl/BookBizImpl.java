package cn.edu.nyist.bookmanv1.biz.impl;

import java.util.List;

import cn.edu.nyist.bookmanv1.Dao.BookDao;
import cn.edu.nyist.bookmanv1.Dao.impl.BookDaoJdbcImpl;
import cn.edu.nyist.bookmanv1.biz.BookBiz;
import cn.edu.nyist.bookmanv1.vo.BookVo;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

public class BookBizImpl implements BookBiz {

	@Override
	public int getAdd(BookVo bookVo) {
		BookDao badd=new BookDaoJdbcImpl();
		return badd.getAdd(bookVo);
	}

	@Override
	public List<TypeVo> getAllType() {
		BookDao allType=new BookDaoJdbcImpl();
		return allType.getAllType();
	}

	
	@Override
	public List<BookVo> getAllBooks(int pageNo) {
		BookDao allBooks=new BookDaoJdbcImpl();
		return allBooks.getAllBooks(pageNo);
	}

	@Override
	public int getTotal() {
		BookDao allBooks=new BookDaoJdbcImpl();
		return allBooks.getTotal();
	}

}
