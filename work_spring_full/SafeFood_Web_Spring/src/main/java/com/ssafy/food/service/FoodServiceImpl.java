package com.ssafy.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Element;

import com.ssafy.food.dao.IFoodDao;
import com.ssafy.food.dto.FoodVO;

@Service(value="FoodServiceImpl")
public class FoodServiceImpl implements IFoodService{

	@Autowired
	private IFoodDao foodmanager;
	
	public FoodServiceImpl() {}

	@Override
	public List<FoodVO> getFoodList() {
		return foodmanager.getFoodList();
	}

	@Override
	public FoodVO getFood(String code) {
		return foodmanager.getFood(code);
	}

	@Override
	public FoodVO getFoodname(String name) {
		return foodmanager.getFoodname(name);
	}

	@Override
	public List<FoodVO> getFoodnamelist(String name) {
		return foodmanager.getFoodnamelist(name);
	}

	@Override
	public List<FoodVO> getFoodmaker(String maker) {
		return foodmanager.getFoodmaker(maker);
	}

	@Override
	public List<FoodVO> getPickList(String id) {
		// TODO Auto-generated method stub
		return foodmanager.getPickList(id);
	}


	
}
