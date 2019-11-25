package com.ssafy.food.dao;

import java.util.List;

public interface ICartDao {
	public boolean addCart(String userid, int foodcode, int amount);
	public List<Integer> getCartList(String userid);
	public boolean delCart(int cartid);
}
