package edu.ssafy.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.Food.Food;
import edu.ssafy.Food.FoodManagerImpl;

public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFoodService food = new FoodServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        String action = req.getParameter("action");
        if (action == null || action.equals("mainpage")) {
            food.mainpage(req, resp);
        }
        else if (action.equals("searchbutton")) {
        	food.searchbutton(req, resp);        	
        }
        else if(action.equals("searchlist")) {
        	food.searchlist(req, resp);
        }
	}
}