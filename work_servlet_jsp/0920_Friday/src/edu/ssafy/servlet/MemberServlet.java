package edu.ssafy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.MemberManager;
import edu.ssafy.model.MemberVO;

@WebServlet("/member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberManager memberManager = MemberManager.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action == null || action.equals("main")) {
			// 메인페이지 메인페이지에는 모든 회원 리스트를 보여주기

			// 데이터 베이스에서 모든 회원의 정보를 가져와서 Arrtibute에 싣고 main.jsp 포워드
			List<MemberVO> memberList = memberManager.getMemberList();
			Cookie[] cookies = request.getCookies();
			List<String> visited = new ArrayList<String>();
			if(cookies !=null) {
				for(Cookie c : cookies) {
					if(!c.getName().equals("JSESSIONID"))
						visited.add(c.getValue());
				}
				request.setAttribute("visited", visited);
			}			
			request.setAttribute("memberList", memberList);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} else if (action.equals("addMember")) {
			// 회원추가작업해주고 메인으로
			// 파라메터들을 모두 꺼내서 MemberVO객체로 묶어서 매니저의 addMember함수에 던져주자
			String name = request.getParameter("name");
			String userid = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			int admin = Integer.parseInt(request.getParameter("admin"));
			MemberVO memberVO = new MemberVO(name, userid, pwd,email,phone,admin);
			memberManager.addMember(memberVO);
			//main으로 리다이렉트해주기
			response.sendRedirect("member.do?action=main");
		} else if (action.equals("addMemberForm")) {
			// 회원가입할 수 있는 페이지로 이동
			request.getRequestDispatcher("addMember.jsp").forward(request, response);
		} else if (action.equals("viewMember")) {
			// 해당 회원 상세보기 페이지로 (로그인 된놈만 볼 수 있음)
			if(request.getSession().getAttribute("id")==null) {
				response.sendRedirect("member.do?action=main");
				return;
			}
			String userid = request.getParameter("userid");
			Cookie cookie = new Cookie(userid, userid);
			response.addCookie(cookie);
			MemberVO memberVO = memberManager.getMember(userid);
			request.setAttribute("member", memberVO);
			request.getRequestDispatcher("viewMember.jsp").forward(request, response);
		} else if (action.equals("login")) {
			// 로그인처리
			String userid = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			if(pwd.equals(memberManager.getMember(userid).getPwd())){
				//로그인 성공
				request.getSession().setAttribute("id", userid);
			}
			response.sendRedirect("member.do?action=main");
		} else if (action.equals("logout")) {
			// 로그아웃 처리
			request.getSession().setAttribute("id", null);
			response.sendRedirect("member.do?action=main");
		}
	}

}
