package com.ssafy.food.service;

import java.util.List;

import org.w3c.dom.Element;

import com.ssafy.food.dto.FoodVO;

public interface IFoodService {

	public List<FoodVO> getFoodList();
	public FoodVO getFood(String code);
	public FoodVO getFoodname(String name);
	public List<FoodVO> getFoodnamelist(String name);
	List<FoodVO> getFoodmaker(String maker);
	public List<FoodVO> getPickList(String id);
}
