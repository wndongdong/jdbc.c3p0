package cn.edu.nyist.bookmanv1.Dao;

import java.util.Date;

public interface BookAddDataDao {

	int getAdd(String name, String descri, String author, int tid, Date pubDate, double price,
			String photo);

}
