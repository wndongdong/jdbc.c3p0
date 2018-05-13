package cn.edu.nyist.bookmanv1.biz.impl;

import java.util.Date;

import cn.edu.nyist.bookmanv1.Dao.BookAddDataDao;
import cn.edu.nyist.bookmanv1.Dao.impl.BookAddDataDaoImpl;
import cn.edu.nyist.bookmanv1.biz.BookAddDataBiz;

public class BookAddDataBizImpl implements BookAddDataBiz {

	@Override
	public int getAdd(String name, String descri, String author, int tid, Date pubDate, double price,
			String photo) {
		BookAddDataDao badd=new BookAddDataDaoImpl();
		return badd.getAdd(name,descri,author,tid,pubDate,price,photo);
	}

}
