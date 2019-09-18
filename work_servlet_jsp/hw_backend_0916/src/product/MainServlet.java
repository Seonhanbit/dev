package product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private Manager mg = Manager.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1 한글처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 2 파라미터 처리

		// 3 업무처리

		// 4 출력처리
		RequestDispatcher rd = request.getRequestDispatcher("viewProducts.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1 한글처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 2 파라미터 처리
		String name = request.getParameter("pname");
		String price = request.getParameter("pprice");
		String sub = request.getParameter("psub");

		// 3 업무처리
		mg.addProduct(name, price, sub);
		int num = mg.getListSize();

		// 4 출력처리
		request.setAttribute("num", Integer.toString(num));
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("sub", sub);
		RequestDispatcher rd = request.getRequestDispatcher("addSuccess.jsp");
		rd.forward(request, response);
	}
}