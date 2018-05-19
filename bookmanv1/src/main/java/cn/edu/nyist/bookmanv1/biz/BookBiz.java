package cn.edu.nyist.bookmanv1.biz;

import java.util.List;

import cn.edu.nyist.bookmanv1.vo.BookVo;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

public interface BookBiz {
	int getAdd(BookVo bookVo);

	List<TypeVo> getAllType();

	List<BookVo> getAllBooks(int pageNo);

	int getTotal();
}
