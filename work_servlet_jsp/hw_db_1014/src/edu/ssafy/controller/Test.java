package edu.ssafy.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.DBCPConnection;
import edu.ssafy.model.Product;
import edu.ssafy.model.ProductDAO;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductDAO man = new ProductDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");
		if (action.equals("registpro")) {
			registPro(request, response);
		} else if (action.equals("search")) {
			search(request, response);
		}
	}


	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> list = man.searchAll();
		if(list!=null) {
			System.out.println("####");
			request.setAttribute("list", list);
			request.getRequestDispatcher("listPro.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}


	private void registPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pno = request.getParameter("pno");
		String pname = request.getParameter("pname");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		boolean res = man.InsertPro(pno, pname, pprice);
		if(res) {
			request.getRequestDispatcher("index.html").forward(request, response);
		}else {
			request.getRequestDispatcher("index.html").forward(request, response);
		}
	}
}
