package ws_backend_0911_선한빛;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login.do")
public class MainServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");        
        String id = req.getParameter("text");
        String pw = req.getParameter("password");
        
        resp.setCharacterEncoding("UTF-8");
        if(id.equals("ssafy") && pw.equals("1111"))
            resp.sendRedirect("Result.html");
    }
}
