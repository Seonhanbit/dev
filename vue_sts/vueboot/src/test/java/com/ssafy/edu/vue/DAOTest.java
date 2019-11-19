package com.ssafy.edu.vue;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.edu.vue.dao.SSAFyDaoImpl;
import com.ssafy.edu.vue.dto.EmployeeDto;

import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class DAOTest {
 @Autowired
 private SSAFyDaoImpl dao;  // 인터페이스를 넣지 마세요.
 @Test
 public void test() {   
    try {
    	
		List<EmployeeDto> lists=dao.findAllEmployees();
		Assert.assertEquals(127, lists.size());             // 정보를 수정해서 테스트하세요.
		Assert.assertEquals(1, lists.get(0).getId());
		Assert.assertEquals("박구곤", lists.get(0).getName());
		Assert.assertEquals(118, lists.get(0).getDept_id());
	} catch (Exception e) {
	}
 }
}