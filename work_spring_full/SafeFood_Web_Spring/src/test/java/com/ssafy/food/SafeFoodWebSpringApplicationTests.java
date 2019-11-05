package com.ssafy.food;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.ssafy.food.dao.IMemberDao;

@SpringBootTest
@ComponentScan("com.ssafy.food.dao")
@ConfigurationProperties(value="application.properties")
public class SafeFoodWebSpringApplicationTests {
	@Autowired
	IMemberDao dao;
	@Test
	public void testFoodDao() {
		boolean login = dao.isLogin("id", "pw");
		assertEquals(false, login);
	}

}
