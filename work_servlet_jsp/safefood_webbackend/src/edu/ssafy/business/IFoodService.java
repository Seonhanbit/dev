package edu.ssafy.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFoodService {

	void pdetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void SignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void Login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
	void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void Logout(HttpServletRequest request, HttpServletResponse response) throws IOException;
	void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void memInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void date(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void itemInCalo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void searchpw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
