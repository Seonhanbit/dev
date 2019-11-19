package com.ssafy.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		LoginApplication.class,
		Jsr310JpaConverters.class
})
public class LoginApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
}
//http://localhost:8397/api/user/checkEmailAvailability?email=rrrrrr@naver.com
//http://localhost:8397/api/user/checkUsernameAvailability?username=rrrrrr

