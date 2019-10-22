package edu.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Member;
import edu.ssafy.dto.Product;
import edu.ssafy.service.ProService;

@Controller
public class ProductController {
	
	@Autowired
	@Qualifier("ProServiceImpl")
	private ProService ser;
	
	@RequestMapping(value="proinsert")
	public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String num = req.getParameter("num");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		// 로직처리 (서비스 부르기)
		ser.insert(new Product(num,name,price));
		// 결과처리
		List<Product> list = ser.selectList();

		mv.addObject("list", list);
		mv.setViewName("product/prolist");
		return mv;
	}

	@RequestMapping(value="prodelete")
	public ModelAndView delete(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String num = req.getParameter("num");

		// 로직처리 (서비스 부르기)
		ser.delete(num);
		// 결과처리
		List<Product> list = ser.selectList();
        mv.addObject("list", list);
        mv.setViewName("product/prolist");
       
		return mv;
	}
	
	@RequestMapping(value="/proupdate")
	public ModelAndView update(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String num = req.getParameter("num");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		// 로직처리 (서비스 부르기)
		ser.update(new Product(num,name,price));
		
		// 화면처리
		List<Product> list = ser.selectList();

		mv.addObject("list", list);
		mv.setViewName("product/prolist");
		return mv;
	}
	
	@RequestMapping(value="proselectone")
	public ModelAndView selectOne(HttpServletRequest req, ModelAndView mv) {
		// 입력처리
		String num = req.getParameter("num");

		// 로직처리 (서비스 부르기)
		Product selectOne = ser.selectOne(num);
		
		// 결과처리
		mv.addObject("list", selectOne);
		mv.setViewName("product/proview");
		return mv;
	}
	
	@RequestMapping(value="prolist")
	public ModelAndView selectList(HttpServletRequest req, ModelAndView mv) {
		// 로직처리 (서비스 부르기)
		List<Product> list = ser.selectList();
		// 결과처리

		mv.addObject("list", list);
		mv.setViewName("product/prolist");
		return mv;
	}
}
