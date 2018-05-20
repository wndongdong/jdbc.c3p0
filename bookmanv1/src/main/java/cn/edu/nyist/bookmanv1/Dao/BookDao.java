package cn.edu.nyist.bookmanv1.Dao;

import java.util.List;

import cn.edu.nyist.bookmanv1.vo.BookVo;
import cn.edu.nyist.bookmanv1.vo.TypeVo;

public interface BookDao {

	int getAdd(BookVo bookVo);

	List<TypeVo> getAllType();

	List<BookVo> getAllBooks(int pageNo, String name, int tid);

	int getTotal();

}
