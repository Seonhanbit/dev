package ws_backend_0916;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1 한글처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 2 파라미터 처리
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 3 업무처리
		// 로그인 가능여부 처리
		boolean islogin = false;
		if (id.equals("ssafy") && password.equals("1111"))
			islogin = true;
		else
			islogin = false;

		// 4 출력처리
		if (islogin) {
			request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
			rd.forward(request, response);
		} else {
			String msg = "아이디 또는 패스워드가 다릅니다.";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1 한글처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 2 파라미터 처리

		// 3 업무처리
		// 로그인 가능여부 처리

		// 4 출력처리
		RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
		rd.forward(request, response);
	}
}