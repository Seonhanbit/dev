package edu.ssafy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.ssafy.dto.BoardDto;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	//swagger 시행시킬거야
	//swagger란 공동 작업 위해 스펙을 정리하기 위해 API 문서화 작업
	
	//root-context에서 <bean class="edu.ssafy.dto.BoardDto"/>한 것 이랑 똑같음
	//어노테이션으로 빈 만들기
	@Bean
	public BoardDto testBoard() {
		return new BoardDto("100","title", "content");
	}
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/**"))// 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
				.paths(PathSelectors.ant("/api/rest*/**")) //(정규식 표현)api 밑에 있는 rest로 시작하는 모든 것들을 문서로 만든다.
				//"/api/rest*" >> *의 의미는 그 뒤에 있는 슬러쉬 구문을 의미함
				//"/api/rest**" >> rest로 시작하는그 뒤 모든 슬러쉬 구문을 의미함 				
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SSAFY API").description("SSAFY API Reference for Developers")
				.termsOfServiceUrl("https://edu.ssafy.com").contact("ssafy@ssafy.com").license("SSAFY License")
				.licenseUrl("ssafy@ssafy.com").version("1.0").build();
	}
	
}
