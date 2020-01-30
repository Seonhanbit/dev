package com.ssafy.food;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SafeFoodWebSpringApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SafeFoodWebSpringApplication.class, args); 
	}

}
