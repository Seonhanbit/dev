package com.ssafy;

public class TV {
	private int num;
	private String name;
	private int price;
	private int su;
	private int inci;
	public int getInci() {
		return inci;
	}
	public void setInci(int inci) {
		this.inci = inci;
	}
	private String type;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public TV() {
		
	}
	public TV(int num, String name, int price, int su, int inci, String type) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.su = su;
		this.inci = inci;
		this.type = type;
	}
	
	public String toString() {
		return "제품 번호 : " +this.num+" 제품 이름 : "+this.name+" 가격 : "+this.price+" 수량 : "+this.su+" 인치 : "+this.inci+" 디스플레이 타입 : "+this.type;
	}
	
}
