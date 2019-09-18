package edu.ssafy.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.MemManager;
import edu.ssafy.model.MemVO;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemManager man = MemManager.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getParameter("action");
		if (action.equals("registmem")) {
			registMem(request, response);
		} else if (action.equals("listmem")) {
			listMem(request, response);
		} else if (action.equals("meminfo")) {
			mainInfo(request, response);
		} else if (action.equals("deletemem")) {
			deleteMem(request, response);
		} else if (action.equals("updatemem")) {
			updateMem(request, response);
		} else if (action.equals("login")) {
			loginMem(request, response);
		}
	}

	private void loginMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");

		boolean res = man.loginInfo(id, pw);
		if (res) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", "로그인 실패");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	private void deleteMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("pid");
		boolean del = man.delMem(id);
		if (del) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", id + "의 삭제를 실패하였습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	private void updateMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String pw = request.getParameter("ppw");
		String addr = request.getParameter("paddr");
		int age = Integer.parseInt(request.getParameter("page"));
		String tel = request.getParameter("ptel");

		boolean res = man.updateMem(id, name, pw, addr, age, tel);

		if (res) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", id + "의 수정에 실패하였습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	private void mainInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		MemVO mem = man.memInfo(id);
		if (mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("meminfo.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원조회 실패");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	private void listMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<MemVO> list = man.getList();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("listmem.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원조회 실패");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	private void registMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		// 2
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String pw = request.getParameter("ppw");
		String addr = request.getParameter("paddr");
		int age = Integer.parseInt(request.getParameter("page"));
		String tel = request.getParameter("ptel");

		// 3
		boolean res = man.addMem(id, name, pw, addr, age, tel);

		// 4
		if (res) {
			// request.setAttribute("result", id + " 등록성공");
			// request.getSession().setAttribute("result", id + " 등록성공");
			response.sendRedirect("result.jsp?result=" + id + URLEncoder.encode(" 등록성공", "UTF-8"));
		} else {
			// request.setAttribute("result", id + " 등록실패");
			response.sendRedirect("result.jsp?result=" + id + URLEncoder.encode(" 등록실패", "UTF-8"));
		}
		// request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
