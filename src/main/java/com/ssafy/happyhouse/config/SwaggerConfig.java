package com.ssafy.happyhouse.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost/happyhouse/swagger-ui/index.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName("HappyHouse")
				.securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller")).paths(regex("/happyhouse/.*")).build();
	}

	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SSAFY VueJS REST API").description(
				"<h1> 1학기 프로젝트 HappyHouse API Reference for Developers</h1><br>")
				.contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com"))
				.license("SSAFY License")
				.licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp").version("1.0").build();
	}
	
	//헤더에 access-token을 확인하기 위한 메소드
	//https://velog.io/@livenow/SpringBoot-Swagger%EB%A5%BC-%ED%86%B5%ED%95%9C-REST-%EC%9A%94%EC%B2%AD%EC%97%90-%EC%A0%84%EC%97%AD-jwt-%EC%9D%B8%EC%A6%9D-%EC%84%A4%EC%A0%95-%ED%95%98%EA%B8%B0
    private SecurityContext securityContext() {
        return springfox
        		.documentation
                .spi.service
                .contexts
                .SecurityContext
                .builder()
                .securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "access-token", "header");
    }

}
