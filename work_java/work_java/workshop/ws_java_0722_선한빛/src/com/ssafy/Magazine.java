package com.ssafy;

public class Magazine {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int year;
	private int month;
	private int price;
	private String desc;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year <=2019 && year >0) {
			this.year = year;
		}else {System.out.println("잘못된 년도입니다.");}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month <13 && month>0) {
			this.month = month;
		}else {System.out.println("잘못된 년도입니다.");}
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Magazine() {
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.year = year;
		this.month = month;
	}
	
	public String toString() {
		return this.isbn+" \t| "+title+" | "+author+" | "+publisher+" \t| "+price+" | "+desc+" | "+year+"."+month;
	}
}
