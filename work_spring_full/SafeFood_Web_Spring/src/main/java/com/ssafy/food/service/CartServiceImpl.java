package com.ssafy.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.food.dao.ICartDao;

@Service
public class CartServiceImpl implements ICartService{
	
	@Autowired
	private ICartDao man;

	@Override
	public boolean addCart(String userid, int foodcode, int amount) {
		return man.addCart(userid, foodcode, amount);
	}

	@Override
	public List<Integer> getCartList(String userid) {
		return man.getCartList(userid);
	}

	@Override
	public boolean delCart(int cartid) {
		return man.delCart(cartid);
	}

}
