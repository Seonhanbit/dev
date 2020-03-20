package com.ssafy.vote;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//만들어준 입터셉터
		//추가할 경로
		//제외할 경로
		//registry.addInterceptor(new Interceptor()).
		//addPathPatterns("/**")
		//.excludePathPatterns("/admin/**");

		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	
}
