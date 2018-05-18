package cn.edu.nyist.bookmanv1.biz.impl;

import cn.edu.nyist.bookmanv1.Dao.BookAddDataDao;
import cn.edu.nyist.bookmanv1.Dao.impl.BookAddDataDaoImpl;
import cn.edu.nyist.bookmanv1.biz.BookAddDataBiz;
import cn.edu.nyist.bookmanv1.vo.BookVo;

public class BookAddDataBizImpl implements BookAddDataBiz {

	@Override
	public int getAdd(BookVo bookVo) {
		BookAddDataDao badd=new BookAddDataDaoImpl();
		return badd.getAdd(bookVo);
	}

}
