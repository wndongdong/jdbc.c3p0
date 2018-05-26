package cn.edu.nyist.bookmanv1.biz;

import java.util.List;

import cn.edu.nyist.bookmanv1.vo.BookVo;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

public interface BookBiz {
	int getAdd(BookVo bookVo);

	List<TypeVo> getAllType();

	List<BookVo> getAllBooks(int pageNo, String name, int tid);

	int getTotal( String name, int tid);

	boolean getDel(int id);

	BookVo selAllBooks(int id);

	int getEditBook(BookVo bookVo);
}
