package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class BookDto implements Serializable{
	private int isbn;
	private String title, author, publisher;
	private int price;
	
	public BookDto() {}

	public BookDto(int isbn, String title, String author, String publisher, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BookVO [isbn=");
		builder.append(isbn);
		builder.append(", title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", publisher=");
		builder.append(publisher);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
	
}
