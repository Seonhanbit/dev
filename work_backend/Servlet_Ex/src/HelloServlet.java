import java.io.*;
import java.util.*;
import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/Hello.do")
public class HelloServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//HttpServletRequest req, 클라이언트가 보낸 요청에 대한 정보들이 들어있음
	//HttpServletResponse resp 서블릿이 응답할 내용이나 정책에 대해서 정해줄 수 있음
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		
		//응답자가 받을 encoding 설정, 제일 먼저 선언할 것 
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<title>Insert title here</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>hello world</h1><p><p>현재 시간 - ");
		
		Calendar today = Calendar.getInstance();
		out.print(today.get(Calendar.HOUR_OF_DAY));
		out.print(":");
		out.print(today.get(Calendar.MINUTE));	
		out.print(":");
		out.print(today.get(Calendar.SECOND));	
		out.print("</p> </body>");
		out.print("</html>");
		out.close();		
	}

}
