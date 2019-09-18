package edu.ssafy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Login.html");
	}

	ArrayList<User> users = new ArrayList<>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); 
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		User user = new User(id,passwd);
		users.add(user);
		
		System.out.println(id + "," + passwd);
		
		String str = "<h1>Connected id is" + id + "<br> passwd : " + passwd+"</h1>";
		response.getWriter().write(str);
	}

}
