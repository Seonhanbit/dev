

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTestServlet
 */
@WebServlet("/sessionTest.do")
public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		//세션 생성
		HttpSession session = request.getSession(true);
		//세선 처음 생성된건지 체크 
		if(session.isNew()) {
			out.println("NEW <br/>");
			out.println("Session Id : "+session.getId());
			out.println("생성시간 : "+new Date(session.getCreationTime()));
			out.println("최근 접근 시간 : "+ new Date(session.getLastAccessedTime()));
			//세션 타임 아웃 시간 조회
			out.println("Max Inactive Interval : "+session.getMaxInactiveInterval());
			//타임 아웃 시간을 1200초로 설정
			session.setMaxInactiveInterval(1200);
		}else {
			out.println("OLD Session <br/>");
			out.println("Session Id :"+session.getId());
			out.println("생성시간 : "+new Date(session.getCreationTime()));
			out.println("최근 접근 시간 : "+ new Date(session.getLastAccessedTime()));
			out.println("Max Inactive Interval : "+session.getMaxInactiveInterval());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
