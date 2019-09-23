package edu.ssafy.model;

public class ProductVO {
	private int num;
	private String name;
	private int price;
	private String description;

	public ProductVO() {
		super();
	}

	public ProductVO(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public ProductVO(int num, String name, int price, String description) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductVO [num=" + num + ", name=" + name + ", price=" + price + ", description=" + description + "]";
	}
}
