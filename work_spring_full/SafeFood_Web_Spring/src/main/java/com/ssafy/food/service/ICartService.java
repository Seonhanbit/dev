package com.ssafy.food.service;

import java.util.List;

import com.ssafy.food.dto.CartVO;

public interface ICartService {
	public boolean addCart(String userid, int foodcode, int amount);
	public List<Integer> getCartList(String userid);
	public boolean delCart(int cartid);
	public List<CartVO> getCartAllList();
	public void update(String userid, int foodcode, int amount);
	public List<Integer> getAmountList(String userid);
}
