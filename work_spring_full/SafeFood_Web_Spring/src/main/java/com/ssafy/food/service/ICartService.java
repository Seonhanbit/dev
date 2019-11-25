package com.ssafy.food.service;

import java.util.List;

public interface ICartService {
	public boolean addCart(String userid, int foodcode, int amount);
	public List<Integer> getCartList(String userid);
	public boolean delCart(int cartid);
}
