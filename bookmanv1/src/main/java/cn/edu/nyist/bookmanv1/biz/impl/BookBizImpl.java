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
	public List<BookVo> getAllBooks(int pageNo,String name,int tid) {
		BookDao allBooks=new BookDaoJdbcImpl();
		return allBooks.getAllBooks(pageNo,name,tid);
	}

	@Override
	public int getTotal(String name,int tid) {
		BookDao allBooks=new BookDaoJdbcImpl();
		return allBooks.getTotal(name,tid);
	}

	@Override
	public boolean getDel(int id) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.getDel(id);
	}


	@Override
	public BookVo selAllBooks(int id) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.selAllBooks(id);
	}

	@Override
	public int getEditBook(BookVo bookVo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.getEdit(bookVo);
	}

}
