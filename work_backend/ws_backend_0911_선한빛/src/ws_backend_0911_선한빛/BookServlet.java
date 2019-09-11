package ws_backend_0911_선한빛;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book.do")
public class BookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		String catalogue[] = req.getParameterValues("catalogue");
		// String title = req.getParameter("title");
		String publisheDate = req.getParameter("publisheDate");
		String publisher[] = req.getParameterValues("publisher");
		String price = req.getParameter("price");
		String description = req.getParameter("description");

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		PrintWriter out = resp.getWriter();
		out.print(" <!DOCTYPE html>                 ");
		out.print(" <html>                          ");
		out.print(" <head>                          ");
		out.print(" <meta charset='UTF-8'>          ");
		out.print(" <title>TEST</title>");
		out.print(" </head>                          ");
		out.print(" <body>                           ");

		out.print(" <table>");
		out.print("      <caption>입력된 도서 정보</caption>");
		out.print("      <thead>");
		out.print("        <tr>");
		out.print("          <th colspan=\"2\">도서 정보</th>");
		out.print("        </tr>");
		out.print("      </thead>");
		out.print("      <tbody>");
		out.print("        <tr>");
		out.print("          <th>도서명</th>");
		out.print("          <td>" + title + "</td>");
		out.print("        </tr>");
		out.print("        <tr>");
		out.print("          <th>도서번호</th>");
		out.print("          <td>" + isbn + "</td>");
		out.print("        </tr>");
		out.print("        <tr>");
		out.print("          <th>도서분류</th>");
		out.print("          <td>");
		if (catalogue != null) {
			for (String c : catalogue) {
				if (c.equals("AA"))
					out.print("프로그래밍");
				else if (c.equals("BB"))
					out.print("운영체제");
				else if (c.equals("CC"))
					out.print("데이터베이스");
				else if (c.equals("DD"))
					out.print("네트워크");
			}
		}
		out.print("</td>");
		out.print("        </tr>");
		out.print("        <tr>");
		out.print("          <th>도서국가</th>");
		out.print("          <td></td>");
		out.print("        </tr>");
		out.print("        <tr>");
		out.print("          <th>출판일</th>");
		out.print("          <td>" + publisheDate + "</td>");
		out.print("        </tr>");
		out.print("        <tr>");
		out.print("          <th>출판사</th>");
		out.print("          <td>");
		if (publisher != null) {
			for (String p : publisher) {
				if (p.equals("p1"))
					out.print("영진출판사");
				else if (p.equals("p2"))
					out.print("한빛미디어");
				else if (p.equals("p3"))
					out.print("프리렉출판사");
				else if (p.equals("p4"))
					out.print("네오솔루션");
				else if (p.equals("p5"))
					out.print("사이버출판사");
			}
		}
		out.print("</td>");
		out.print("        </tr>");
		out.print("        <tr>");
		out.print("          <th>저자</th>");
		out.print("          <td></td>");
		out.print("        </tr>");
		out.print("        <tr>");
		out.print("          <th>도서가격</th>");
		out.print("          <td>" + price + "</td>");
		out.print("        </tr>");
		out.print("        <tr>");
		out.print("          <th>도서설명</th>");
		out.print("          <td>" + description + "</td>");
		out.print("        </tr>");
		out.print("      </tbody>");
		out.print("      <tfoot>");
		out.print("        <tr>");
		out.print("          <td colspan=\"2\">Table Foot</td>");
		out.print("        </tr>");
		out.print("      </tfoot>");
		out.print("    </table>");
		out.print("");
		out.print("");

		// out.print(" <br/>content:" + content);
		// out.print(" <br/>gender:" + gender);
		// out.print(gender);
		out.print(" </body>                   ");
		out.print(" </html>                   ");
	}
}
