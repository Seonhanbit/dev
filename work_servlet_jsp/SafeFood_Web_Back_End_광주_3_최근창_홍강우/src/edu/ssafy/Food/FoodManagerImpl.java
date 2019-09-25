package edu.ssafy.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ssafy.handler.FoodSaxParser;
import edu.ssafy.model.ConnectionProxy;

public class FoodManagerImpl implements IFoodManager {

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	List<Food> list;

	public FoodManagerImpl() {

//		InsertFood();
	}

	public void InsertFood() {

		list = new FoodSaxParser().getFoods();
		String query = "insert into food values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			con = ConnectionProxy.getConnection();
			pst = con.prepareStatement(query);
			for (int i = 0; i < list.size(); i++) {

				Food food = new Food();
				food = list.get(i);
				pst.setInt(1, food.getCode());
				pst.setString(2, food.getName());
				pst.setDouble(3, food.getSupportpereat());
				pst.setDouble(4, food.getCalory());
				pst.setDouble(5, food.getCarbo());
				pst.setDouble(6, food.getProtein());
				pst.setDouble(7, food.getFat());
				pst.setDouble(8, food.getSugar());
				pst.setDouble(9, food.getNatrium());
				pst.setDouble(10, food.getChole());
				pst.setDouble(11, food.getFattyacid());
				pst.setDouble(12, food.getTransfat());
				pst.setString(13, food.getMaker());
				pst.setString(14, food.getMaterial());
				pst.setString(15, food.getImg());
				pst.setString(16, food.getAllergy());
				pst.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert Failed...");
		} finally {
			close();
		}
	}

	public List<Food> SearchAll() {

		String query = "select *from food";
		List<Food> list = new ArrayList<>();

		try {
			con = ConnectionProxy.getConnection();
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();

			while (rs.next()) {

				Food f = new Food();
				f.setCode(rs.getInt("code"));
				f.setName(rs.getString("name"));
				f.setSupportpereat(rs.getDouble("supportpereat"));
				f.setCalory(rs.getDouble("calory"));
				f.setCarbo(rs.getDouble("carbo"));
				f.setProtein(rs.getDouble("protein"));
				f.setFat(rs.getDouble("fat"));
				f.setSugar(rs.getDouble("sugar"));
				f.setNatrium(rs.getDouble("natrium"));
				f.setChole(rs.getDouble("chole"));
				f.setFattyacid(rs.getDouble("fattyacid"));
				f.setTransfat(rs.getDouble("transfat"));
				f.setMaker(rs.getString("maker"));
				f.setMaterial(rs.getString("material"));
				f.setImg(rs.getString("img"));
				f.setAllergy(rs.getString("allergy"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Name Search Failed...");
		} finally {
			close();
		}
		return list;
	}

	public List<Food> ConditionSearch(String name, String key) {

		String query = "select *from food where " + key + " like ?";
		List<Food> list = new ArrayList<>();

		try {
			con = ConnectionProxy.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, "%" + name + "%");
			rs = pst.executeQuery();

			while (rs.next()) {

				Food f = new Food();
				f.setCode(rs.getInt("code"));
				f.setName(rs.getString("name"));
				f.setSupportpereat(rs.getDouble("supportpereat"));
				f.setCalory(rs.getDouble("calory"));
				f.setCarbo(rs.getDouble("carbo"));
				f.setProtein(rs.getDouble("protein"));
				f.setFat(rs.getDouble("fat"));
				f.setSugar(rs.getDouble("sugar"));
				f.setNatrium(rs.getDouble("natrium"));
				f.setChole(rs.getDouble("chole"));
				f.setFattyacid(rs.getDouble("fattyacid"));
				f.setTransfat(rs.getDouble("transfat"));
				f.setMaker(rs.getString("maker"));
				f.setMaterial(rs.getString("material"));
				f.setImg(rs.getString("img"));
				f.setAllergy(rs.getString("allergy"));
				list.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Name Search Failed...");
		} finally {
			close();
		}
		return list;
	}

	public void close() {

		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("closed failed...");
		}
	}
}
