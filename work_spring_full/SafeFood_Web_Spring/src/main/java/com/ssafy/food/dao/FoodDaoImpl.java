package com.ssafy.food.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Element;

import com.ssafy.food.dto.FoodVO;

@Repository
public class FoodDaoImpl implements IFoodDao {

	@Autowired
	SqlSession session;

	@Override
	public List<FoodVO> getFoodList() {
		return session.selectList("food.selectList");
	}

	@Override
	public FoodVO getFood(String code) {
		return session.selectOne("food.selectOne", code);
	}

	@Override
	public FoodVO getFoodname(String name) {
		return session.selectOne("food.selectName",name);
	}

	@Override
	public List<FoodVO> getFoodnamelist(String name) {
		return session.selectList("food.selectNameList", name);
	}

	@Override
	public List<FoodVO> getFoodmaker(String maker) {
		return session.selectList("food.selectMaker", maker);
	}

	@Override
	public List<FoodVO> getPickList(String id) {
		// TODO Auto-generated method stub
		return session.selectList("food.pickList", id);
	}
}
