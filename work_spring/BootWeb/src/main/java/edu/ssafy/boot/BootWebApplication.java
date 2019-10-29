package edu.ssafy.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootWebApplication.class, args);
		
		//위와 같은 의미인 설정 파일
		/*
		 * new SpringApplicationBuilder(BootWebApplication.class)
		 * .properties("spring.config.location=classpath:/application/properties, classpath:/application.yml"
		 * ) .run(args);
		 */
	}

}
