package edu.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.business.FoodServiceImpl;
import edu.ssafy.business.IFoodService;
import edu.ssafy.model.FoodManagerImpl;
import edu.ssafy.model.IFoodManager;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IFoodService service = new FoodServiceImpl();
	
	IFoodManager mem = new FoodManagerImpl();

	public MainServlet() {
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String url = getServletContext().getRealPath("/WEB-INF/res/foodInfo.xml");
		String url2 = getServletContext().getRealPath("/WEB-INF/res/FoodNutritionInfo.xml");
		
		try {
			mem.loadData(url, url2);
			// mem.loadData("/WebContent/WEB-INF/res/foodInfo.xml");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action == null || action.equals("main")) {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else if (action.equals("pdetail")) {
			service.pdetail(request, response);
		} else if (action.equals("productInfo")) {
			service.productInfo(request, response);
		} else if (action.equals("SignUp")) {
			service.SignUp(request, response);
		} else if (action.equals("Login")) {
			service.Login(request, response);
		} else if (action.equals("Delete")) {
			service.Delete(request, response);
		} else if (action.equals("Update")) {
			service.Update(request, response);
		}else if(action.equals("Logout")) {
			service.Logout(request,response);
		}else if(action.equals("searchProduct")) {
			service.search(request,response);
		}else if(action.equals("memInfo")) {
			service.memInfo(request, response);
		}else if(action.equals("date")) {
			service.date(request, response);
		}else if(action.equals("calo")) {
            service.itemInCalo(request,response);
        }else if(action.equals("searchpw")) {
        	service.searchpw(request, response);
        }
	}
}
