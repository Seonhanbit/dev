package com.ssafy.food;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.food.dto.LoadJsonData;

@Configuration
public class AppConfig {
	@Bean
	public LoadJsonData loadJson(){
		
		return new LoadJsonData();
	}
}
