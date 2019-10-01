package edu.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.service.MemService;
import edu.ssafy.service.MemServiceImpl;

public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemService ser = new MemServiceImpl();   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "memreg":
			memReg(request,response);
			break;

		default:
			break;
		}
	}

	private void memReg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("pid");
		String pw = request.getParameter("ppw");
		String name = request.getParameter("pname");
		String addr = request.getParameter("paddr");
		
		boolean res = ser.memReg(id, pw, name, addr);
		
		if(res) {
			response.sendRedirect("memlist.jsp");
		}else {
			response.sendRedirect("memreg.jsp");
		}
		
	}

}






