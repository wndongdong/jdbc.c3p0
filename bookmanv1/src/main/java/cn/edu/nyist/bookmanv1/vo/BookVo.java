package cn.edu.nyist.bookmanv1.vo;

import java.io.Serializable;
import java.util.Date;

public class BookVo implements Serializable{

	
	/**
	 * 使用BeanUtils，则要实现序列化接口，并构造无参构造方法
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int tid;
	private String name;
	private String photo;
	private String author;
	private double price;
	private Date pubDate;
	private String descri;
	
	public BookVo() {
			
		}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

}
