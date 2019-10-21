package edu.ssafy.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/testmv")
	public ModelAndView testModel(ModelAndView mv) {
		mv.addObject("res", "6번 누르기");
		mv.setViewName("test");
		return mv;
	}
	
	//리턴타입은 다 jsp 파일 이름을 나타냄
	//test도 되고, test2도 된다
	@RequestMapping(value= {"/test", "/test2"})
	public String test(Model m) {
		m.addAttribute("res","Hello test");
		return "test";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest req, HttpServletResponse res) {
		//인자 안받아도 되지만 기본적으로 model
		//HttpServletRequest req, HttpServletResponse res 인자 다 받을 수 있고, 안 받을 수도 있음
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
