package com.ssafy.food.dto;

public class CartVO {
	private int cartid;
	private String userid;
	private int foodcode;
	private int amount;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getFoodcode() {
		return foodcode;
	}
	public void setFoodcode(int foodcode) {
		this.foodcode = foodcode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public CartVO(int cartid, String userid, int foodcode, int amount) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.foodcode = foodcode;
		this.amount = amount;
	}
	public CartVO(String userid, int foodcode, int amount) {
		this.userid = userid;
		this.foodcode = foodcode;
		this.amount = amount;
	}
	public CartVO() {
	}
	@Override
	public String toString() {
		return "CartVO [cartid=" + cartid + ", userid=" + userid + ", foodcode=" + foodcode + ", amount=" + amount
				+ "]";
	}
	
}
