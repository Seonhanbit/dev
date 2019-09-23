package edu.ssafy.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ssafy.model.ProductVO;

public interface IProductService {
	public void delPro(HttpServletRequest request, HttpServletResponse response) throws IOException;

	public void viewPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public void addProForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public void addPro(HttpServletRequest request, HttpServletResponse response) throws IOException;

	public void listPro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
