package edu.ssafy.business;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.IMemManager;
import edu.ssafy.model.MemManagerImpl;
import edu.ssafy.model.MemVO;

public class MemServiceImpl implements IMemService{
	private IMemManager man = new MemManagerImpl();
	
	public void logoutMem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		request.getSession().setAttribute("isLogin", null);
/*		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			cookies[i].getName();
			cookies[i].getValue();
			cookies[i].setMaxAge(0);
		}*/
		response.sendRedirect("login.html");
	}

	public void loginMem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		
		boolean isLogin = man.loginInfo(id, pw);
		if (isLogin) {
			request.getSession().setAttribute("isLogin", "isLogin");
			request.getSession().setAttribute("id", id);
			/*Cookie cooklogin = new Cookie("isLogin", isLogin+"");
			Cookie cookid = new Cookie("isLogin", id);
			response.addCookie(cooklogin);
			response.addCookie(cookid);*/
			response.sendRedirect("main.do?action=listmem");
			//request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", "로그인 실패");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	public void updateMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		// 2.파라미터 작업(name을 쫓아감) 파라미터는 기본적으로 문자열로 날아옴
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String pw = request.getParameter("ppw");
		String addr = request.getParameter("paddr");
		int age = Integer.parseInt(request.getParameter("page"));
		String tel = request.getParameter("ptel");
		// 3.업무처리
		boolean res = man.updateMem(id, name, pw, addr, age, tel);
		// 4.출력처리
		if (res) {
			request.getRequestDispatcher("main.do?action=listmem").forward(request, response);
		} else {
			request.setAttribute("result", id + "의 업데이트를 실패하였습니다.");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}

	}

	public void deleteMem(HttpServletRequest request, HttpServletResponse response)
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

	public void mainInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("uid");
		MemVO mem = man.memInfo(id);
		if (mem != null) {
			request.setAttribute("mem", mem);
			request.getRequestDispatcher("meminfo.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원 조회 실패");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	public void listMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<MemVO> list = man.getList();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("listmen.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "회원 조회 실패");
			request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

	public void registMem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.한글처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		// 2.파라미터 작업(name을 쫓아감) 파라미터는 기본적으로 문자열로 날아옴
		String id = request.getParameter("pid");
		String name = request.getParameter("pname");
		String pw = request.getParameter("ppw");
		String addr = request.getParameter("paddr");
		int age = Integer.parseInt(request.getParameter("page"));
		String tel = request.getParameter("ptel");
		// 3.업무처리S
		boolean res = man.addMem(id, name, pw, addr, age, tel);
		// 4.출력처리
		if (res) {
			//request.setAttribute("result", id + " 등록 성공");
			//request.getSession().setAttribute("result", id + " 등록 성공");
			response.sendRedirect("result.jsp?result="+id+URLEncoder.encode(" 등록 성공", "UTF-8"));
		} else {
			//request.setAttribute("result", id + " 등록  실패");
			String msg = URLEncoder.encode(" 등록 실패", "UTF-8");
			response.sendRedirect("result.jsp?result="+id+msg);
		}
		//request.getRequestDispatcher("result.jsp").forward(request, response);

	}
}
