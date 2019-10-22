package edu.ssafy.dto;

public class Product {
	private String num;
	private String name;
	private String price;
	public Product() {}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Product(String num, String name, String price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + "]";
	}
		
}
