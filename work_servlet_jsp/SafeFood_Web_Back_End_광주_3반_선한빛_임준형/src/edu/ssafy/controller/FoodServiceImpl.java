package edu.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.Food.Food;
import edu.ssafy.Food.FoodManagerImpl;
import edu.ssafy.Food.IFoodManager;

public class FoodServiceImpl implements IFoodService{

	private IFoodManager food = new FoodManagerImpl();
	
	public void searchlist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.sendRedirect("searchlist.jsp");
	}

	public void searchbutton(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("key");
        String value = req.getParameter("value");
        
        List<Food> list = food.ConditionSearch(value, key);
    	req.setAttribute("foodlist", list);
    	req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

	public void mainpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
}
