package com.ssafy;

public class Magazine extends Book {
	private int year;
	private int month;
	
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
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisher() {
		return publisher;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}
	
	public Magazine() {
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	
	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", isbn=" + isbn + ", title=" + title + ", author="
				+ author + ", publisher=" + publisher + ", price=" + price + ", desc=" + desc + "]";
	}
	
}
