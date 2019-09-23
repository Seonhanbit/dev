package edu.ssafy.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import edu.ssafy.model.ProductManager;
import edu.ssafy.model.ProductVO;
import edu.ssafy.service.IProductService;
import edu.ssafy.service.ProductService;

@WebServlet("/product.do")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IProductService service = new ProductService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action == null || action.equals("listProduct")) {
			service.listPro(request, response);
		} else if (action.equals("addProduct")) {
			service.addPro(request, response);
		} else if (action.equals("addProductForm")) {
			service.addProForm(request, response);
		} else if (action.equals("viewProduct")) {
			service.viewPro(request, response);
		} else if (action.equals("delProduct")) {
			service.delPro(request, response);
		}
		// doGet(request, response);
	}
}
