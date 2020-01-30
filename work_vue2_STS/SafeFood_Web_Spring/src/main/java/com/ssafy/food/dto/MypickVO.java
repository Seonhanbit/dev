package com.ssafy.food.dto;

public class MypickVO {
	private int code;
	private String image;
	private String name;
	private int amount;
	private boolean include;
	

	public boolean isInclude() {
		return include;
	}
	public void setInclude(boolean include) {
		this.include = include;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public MypickVO(int code, String image, String name, boolean include) {
		super();
		this.code = code;
		this.image = image;
		this.name = name;
		this.include = include;
	}
	
	public MypickVO(int code, String image, String name, boolean include, int amount) {
		super();
		this.code = code;
		this.image = image;
		this.name = name;
		this.include = include;
		this.amount = amount;
	}
	
	public MypickVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MypickVO [code=" + code + ", image=" + image + ", name=" + name + ", amount=" + amount + "]";
	}

}
