package edu.ssafy.Food;

import java.util.List;

public interface IFoodManager {

	public void InsertFood();
	public List<Food> SearchAll();
	public List<Food> ConditionSearch(String name, String key);
	public void close();
}
