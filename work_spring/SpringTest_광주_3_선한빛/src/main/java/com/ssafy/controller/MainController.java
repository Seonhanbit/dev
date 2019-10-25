package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.pms.Phone;
import com.ssafy.service.IPhoneService;

@Controller("/")
public class MainController {

	public MainController(){}
	
	@Autowired
	IPhoneService ser;
	
	@ExceptionHandler(Exception.class)
	public String exception(Exception e, Model m) {
		m.addAttribute("exception", e);
		return "Error";
	}
	
	@RequestMapping("regPhone.do")
	public String insert() {
		return "PhoneReg";
	}
	
	@RequestMapping("phonereg")
	public ModelAndView insert(ModelAndView mv, HttpServletRequest req) {
		String num = req.getParameter("num");
		String model = req.getParameter("model");
		String price = req.getParameter("price");
		String vcode = req.getParameter("vcode");
		ser.insert(new Phone(num,model,Integer.parseInt(price),vcode));		
		mv.setViewName("Result");
		return mv;
	}
	
	@RequestMapping("selectlist")
	public ModelAndView selectlist(ModelAndView mv, HttpServletRequest req) {
		List<Phone> list = ser.selectList();
		mv.addObject("list", list);
		mv.setViewName("PhoneList");
		return mv;
	}
	
	@RequestMapping("selectOne")
	public ModelAndView selectOne(ModelAndView mv, String num) {
		Phone p = ser.selectOne(num);
		mv.addObject("p", p);
		mv.setViewName("PhoneView");
		return mv;
	}
	
	@RequestMapping("delete")
	public ModelAndView delete(ModelAndView mv, HttpServletRequest req) {
		String num = req.getParameter("num");
		ser.delete(num);
		mv.setViewName("redirect:selectlist");
		return mv;
	}
}