package hw_java_0730;

import java.io.Serializable;

public class Product implements Serializable{
	private int num;
	private String name;
	private int price;
	private int su;

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

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public Product() {

	}

	public Product(int num, String name, int price, int su) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.su = su;
	}
	
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", su=" + su + "]";
	}	

}
