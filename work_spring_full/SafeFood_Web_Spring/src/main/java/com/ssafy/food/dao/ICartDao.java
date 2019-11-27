package com.ssafy.food.dao;

import java.util.List;

import com.ssafy.food.dto.CartVO;

public interface ICartDao {
	public boolean addCart(String userid, int foodcode, int amount);
	public List<Integer> getCartList(String userid);
	public boolean delCart(int cartid);
	public List<CartVO> getCartAllList();
	public void update(String userid, int foodcode, int amount);
	public List<Integer> getAmountList(String userid);
	public List<CartVO> getCartUserList(String userid);
}
