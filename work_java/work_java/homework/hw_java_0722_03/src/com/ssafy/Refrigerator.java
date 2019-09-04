package com.ssafy;

public class Refrigerator {
	private int num;
	private String name;
	private int price;
	private int su;
	private int weight;
	
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Refrigerator(){
		
	}
	
	public Refrigerator(int num, String name, int price, int su, int weight) {
		this();
		this.num = num;
		this.name = name;
		this.price = price;
		this.su = su;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "제품 번호 : " +this.num+" 제품 이름 : "+this.name+" 가격 : "+this.price+" 수량 : "+this.su+" 용량 : "+this.weight;
	}
	
	
}
