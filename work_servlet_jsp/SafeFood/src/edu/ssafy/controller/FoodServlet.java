package edu.ssafy.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.Food.Food;
import edu.ssafy.Food.FoodManagerImpl;
import edu.ssafy.Food.VisitCount;

public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFoodService food = new FoodServiceImpl();
	private VisitCount fooddate = new VisitCount();
	
	@Override
	public void init() throws ServletException {
		
		super.init();
		FoodManagerImpl loadfood;
		loadfood = new FoodManagerImpl();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat datefor = new SimpleDateFormat("yyyy:MM:dd-hh:mm:ss");
		String datetime = datefor.format(cal.getTime());
		
		System.out.println(datetime);
		fooddate.VisitCounting(datetime);
		
		System.out.println(getServletContext().getRealPath("WEB-INF/res/foodInfo.xml"));
		System.out.println(getServletContext().getRealPath("WEB-INF/res/FoodNutritionInfo.xml"));
		loadfood.InsertFood(getServletContext().getRealPath("WEB-INF/res/foodInfo.xml"), getServletContext().getRealPath("WEB-INF/res/FoodNutritionInfo.xml"));
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num =  "누적 방문자수: " + String.valueOf(fooddate.Visited()) + "명";
		System.out.println(num);
		
		req.getSession().setAttribute("visited", num);
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
        else if(action.equals("myallergy")) {
        	food.allergyprod(req, resp);
        }else if(action.equals("detail")) {
        	food.detail(req,resp);
        }
	}
}