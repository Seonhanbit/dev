package com.ssafy.food.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.food.dto.CartVO;

@Repository
public class CartDaoImpl implements ICartDao {

	@Autowired
	SqlSession session;

	@Override
	public boolean addCart(String userid, int foodcode, int amount) {
		CartVO c = new CartVO(userid, foodcode, amount);
		int n = session.insert("cart.insertCart", c);
		if (n == 1)
			return true;
		else
			return false;
	}

	@Override
	public List<Integer> getCartList(String userid) {
		return session.selectList("cart.selectList", userid);
	}

	@Override
	public boolean delCart(int cartid) {
		int n = session.delete("cart.deleteCart", cartid);
		if (n != 0)
			return true;
		else
			return false;
	}

	@Override
	public List<CartVO> getCartAllList() {
		return session.selectList("cart.selectAllList");
	}

	@Override
	public void update(String userid, int foodcode, int amount) {
		CartVO c = new CartVO(userid, foodcode, amount);
		session.selectList("cart.updateAmount",c);	
	}

	@Override
	public List<Integer> getAmountList(String userid) {
		return session.selectList("cart.selectAmountList", userid);
	}

	@Override
	public List<CartVO> getCartUserList(String userid) {
		return session.selectList("cart.selectuseridList", userid);
	}

}
