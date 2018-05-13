package cn.edu.nyist.bookmanv1.biz;

import java.util.Date;

public interface BookAddDataBiz {

	int getAdd(String name, String descri, String author, int tid, Date pubDate, double price,
			String string);
}
