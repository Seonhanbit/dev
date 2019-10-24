package edu.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ssafy.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService ser;
	@RequestMapping(value= {"/","index"})
	public String index() {
		
		return "index";
	}
	
}
