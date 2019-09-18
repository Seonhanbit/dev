package ws_backend_0911;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book.do")
public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		
		resp.setCharacterEncoding("UTF-8");
		if(id.equals("ssafy") && pw.equals("1111"))
			resp.sendRedirect("Result.html");
		else
			resp.sendRedirect("Login.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String isbn = req.getParameter("isbn1") + "-" + req.getParameter("isbn2") + "-" + req.getParameter("isbn3");	//*
		String title = req.getParameter("title");			//*
		String catalogue = req.getParameter("catalogue");	//*
		String nation = req.getParameter("nation");
		String publisheDate = req.getParameter("publisheDate");
		String publisher = req.getParameter("publisher");
		String author = req.getParameter("author");			//*
		String price = req.getParameter("price");
		String currency = req.getParameter("currency");
		System.out.println(currency);
		String description = req.getParameter("description");
		
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE html");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<link rel=\"stylesheet\" href=\"./css/design.css\">");
		out.write("</head>");
		
		out.write("<body>");
		out.write("<table class=\"title_table\">");
		out.write("<tr>");
		out.write("<td class=\"title_table\"><h2>입력된 도서 정보</h2></td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("<table>");
		out.write("<tr>");
		out.write("<td  id=\"td_cat\" colspan='2'>도서 정보</td>");
		out.write("</tr>");
		out.write("<tr>");		
		out.write("<td id=\"td_cat\">도서명</td>");
		out.write("<td>" + title);
		out.write("</td>");
		out.write("</tr>");
		out.write("<tr>");		
		out.write("<td id=\"td_cat\">도서번호</td>");
		out.write("<td>" + isbn);
		out.write("</td>");
		out.write("</tr>");
		out.write("<tr>");		
		out.write("<td id=\"td_cat\">도서분류</td>");
		out.write("<td>" + catalogue);
		out.write("</td>");
		out.write("</tr>");
		out.write("<tr>");		
		out.write("<td id=\"td_cat\">도서국가</td>");
		out.write("<td>" + nation);
		out.write("</td>");
		out.write("</tr>");
		out.write("<tr>");		
		out.write("<td id=\"td_cat\">출판일</td>");
		out.write("<td>" + publisheDate);
		out.write("</td>");
		out.write("</tr>");
		out.write("<tr>");		
		out.write("<td id=\"td_cat\">출판사</td>");
		out.write("<td>" + publisher);
		out.write("</td>");
		out.write("</tr>");
		out.write("<tr>");		
		out.write("<td id=\"td_cat\">저 자</td>");
		out.write("<td>" + author);
		out.write("</td>");
		out.write("</tr>");
		out.write("<tr>");		
		out.write("<td id=\"td_cat\">도서가격</td>");
		if(currency.equals("원")) {
			out.write("<td>" + price + currency);
		}
		else if(currency.equals("달러")) {
			out.write("<td>" + price + currency);
		}
		out.write("</td>");
		out.write("</tr>");
		out.write("<tr>");		
		out.write("<td id=\"td_cat\">도서설명</td>");
		out.write("<td>" + description);
		out.write("</td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("<table class=\"title_table\">");
		out.write("<tr>");
		out.write("<td class=\"title_table\"><a href=\"./book.html\">도서 등록</a></td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("</body>");
		out.write("</html>");
	}
}