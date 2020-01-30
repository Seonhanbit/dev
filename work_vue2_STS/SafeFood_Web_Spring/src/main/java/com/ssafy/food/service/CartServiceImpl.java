package com.ssafy.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.food.dao.ICartDao;
import com.ssafy.food.dto.CartVO;

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

	@Override
	public List<CartVO> getCartAllList() {
		return man.getCartAllList();
	}

	@Override
	public void update(String userid, int foodcode, int amount) {
		man.update(userid, foodcode, amount);
	}

	@Override
	public List<Integer> getAmountList(String userid) {
		return man.getAmountList(userid);
	}

	@Override
	public List<CartVO> getCartUserList(String userid) {
		return man.getCartUserList(userid);
	}

}
