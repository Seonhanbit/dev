package com.ssafy.food.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFoodController {
	
	@RequestMapping("/")
	public String index() {
		return "Hello Boot";
	}

}
