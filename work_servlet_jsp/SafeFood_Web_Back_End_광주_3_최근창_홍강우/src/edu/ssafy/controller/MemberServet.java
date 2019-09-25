package edu.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberServet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMemService service = new MemServiceImpl();

	public void init() throws ServletException {
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");
		// 메인페이지로 돌아가는 것 구현하기
		if (action.equals("registmem")) {
			service.registMem(request, response);
		} else if (action.equals("searchpw")) {
			service.searchpw(request, response);
		} else if (action.equals("updatemem")) {
			service.updateMem(request, response);
		} else if (action.equals("deletemem")) {
			service.deleteMem(request, response);
		} else if (action.equals("meminfo")) {
			service.memInfo(request, response);
		} else if (action.equals("login")) {
			service.loginMem(request, response);
		} else if (action.equals("logout")) {
			service.logoutMem(request, response);
		}
	}
}
