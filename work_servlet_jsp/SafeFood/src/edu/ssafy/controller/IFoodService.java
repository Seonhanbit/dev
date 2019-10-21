package edu.ssafy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFoodService {

	public void searchlist(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
	public void searchbutton(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	public void mainpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	public void allergyprod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	public void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;
}
