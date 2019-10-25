package edu.ssafy.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ssafy.dto.Board;
import edu.ssafy.dto.BoardMember;
import edu.ssafy.repository.MemberRepositoryMyBatis;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MemberRepositoryMyBatis repo;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("test");
		List<BoardMember> joinTest = repo.joinTest();
		for(BoardMember bm : joinTest) {
			System.out.println(bm.toString());
		}
		
		return "index";
	}
	
	
	@RequestMapping(value = {"/","index"})
	public String home(HttpServletRequest req, HttpServletResponse res,Locale locale,  Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "index";
	}
}
