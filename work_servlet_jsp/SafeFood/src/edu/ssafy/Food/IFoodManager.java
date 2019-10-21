package edu.ssafy.Food;

import java.util.List;

public interface IFoodManager {

	public void InsertFood(String str1, String str2);
	public List<Food> SearchAll();
	public List<Food> ConditionSearch(String name, String key);
	public String AllergySearch(String id);
	public void close();
	List<Food> CalorySearch(String cal);
	List<String[]> powersetSearch(String cal);
	public Food detail(String code);
}
