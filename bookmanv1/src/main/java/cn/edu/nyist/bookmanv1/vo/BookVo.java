package cn.edu.nyist.bookmanv1.vo;

import java.io.Serializable;
import java.util.Date;

public class BookVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String descri;
	private String author;
	private int id;
	private Date pubDate;
	private double price;
	private String photo;
	private int tid;
	
	public BookVo() {
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescri() {
		return this.descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPubDate() {
		return this.pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPhoto() {
		return this.photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getTid() {
		return this.tid;
	}
	public void setTid(String tid) {
		this.tid = Integer.parseInt(tid);
	}
	
}
