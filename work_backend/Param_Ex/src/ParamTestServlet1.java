import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/param1.do")
public class ParamTestServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
        String text = req.getParameter("text");
        String password = req.getParameter("password");
        String hobby[] = req.getParameterValues("hobby");
        String job[] = req.getParameterValues("job");
        String content = req.getParameter("content");
        String gender = req.getParameter("gender");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(" <!DOCTYPE html>                 ");
        out.print(" <html>                          ");
        out.print(" <head>                          ");
        out.print(" <meta charset='UTF-8'>          ");
        out.print(" <title>Insert title here</title>");
        out.print(" </head>                          ");
        out.print(" <body>                           ");
        out.print(" <h1>전송된 데이터</h1><p>            ");
        out.print(" <br/>text:" + text);
        out.print(" <br/>password:" + password);
        if (hobby != null) {
            out.print(" <br/>hobby:");
            for (String h : hobby) {
                out.print(h + " ");
            }
        }
        out.print(" <br/>job:");
        for (String j : job) {
            out.print(j + " ");
        }
        out.print(" <br/>content:" + content);
        out.print(" <br/>gender:" + gender);
        out.print(gender);
        out.print(" </body>                   ");
        out.print(" </html>                   ");
    }
}