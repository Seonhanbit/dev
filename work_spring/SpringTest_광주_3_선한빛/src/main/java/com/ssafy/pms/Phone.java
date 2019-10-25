package com.ssafy.pms;

public class Phone {
	private String num;
	private String model;
	private int price;
	private String vcode;

	public Phone() {
	}

	public Phone(String num, String model, int price, String vcode) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
		this.vcode = vcode;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phone [num=");
		builder.append(num);
		builder.append(", model=");
		builder.append(model);
		builder.append(", price=");
		builder.append(price);
		builder.append(", vcode=");
		builder.append(vcode);
		builder.append("]");
		return builder.toString();
	}

}