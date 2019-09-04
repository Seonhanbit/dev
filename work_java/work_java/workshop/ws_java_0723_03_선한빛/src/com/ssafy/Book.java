package com.ssafy;

public class Book {
	protected String isbn;
	protected String title;
	protected String author;
	protected String publisher;
	protected int price;
	protected String desc;
	
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
	
	public Book() {
	}

	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", price=" + price + ", desc=" + desc + "]";
	}


}
