package com.ssafy.edu.vue;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class JsonServiceTest {
 @Autowired
 private TestRestTemplate restTemplate;
 @Test
 public void test() {
	ResponseEntity<List> res=
	this.restTemplate.getForEntity("/api/findAllEmployees", List.class);
	List<LinkedHashMap<String, Object>> usersMap =res.getBody();
	System.out.println(usersMap.get(0));
	Assert.assertEquals(usersMap.get(0).get("id").toString(),"1");
	Assert.assertEquals(usersMap.get(0).get("name"),"박구곤");
	Assert.assertEquals(usersMap.get(0).get("dept_id").toString(),"118");
	Assert.assertEquals(res.getStatusCode(), HttpStatus.OK);
 }
}