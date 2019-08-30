package ws_java_0730_03_선한빛;

import java.io.Serializable;

public class Book implements Serializable{
	private String isbn;
	private String title;
	private int price;
	private int quantity;
	
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", quantity=" + quantity + "]";
	}
	public Book() {
		
	}
	public Book(String isbn, String title, int price, int quantity) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	
}
