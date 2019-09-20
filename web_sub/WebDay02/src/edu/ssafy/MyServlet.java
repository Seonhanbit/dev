package edu.ssafy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String name1 = request.getParameter("name1");
    	String name2 = request.getParameter("name2");
    	
    	String msg =  "<friends>" + 
    	"	<friend>" + 
    	"		<name>"
    	+ name1
    	+ "</name>" + 
    	"		<age>25</age>" + 
    	"	</friend>" + 
    	"	<friend>" + 
    	"		<name>"
    	+ name2
    	+ "</name>" + 
    	"		<age>35</age>" + 
    	"	</friend>" + 
    	"</friends>";
    	
    	response.getWriter().write(msg);
	}

}
