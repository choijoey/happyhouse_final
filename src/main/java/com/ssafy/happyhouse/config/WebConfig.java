package com.ssafy.happyhouse.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.happyhouse.interceptor.JwtInterceptor;
import com.ssafy.happyhouse.interceptor.JwtInterceptor2;

//import com.ssafy.vue.interceptor.JwtInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private static final String[] EXCLUDE_PATHS = {"/user/**", "/error/**","/swagger-ui.html","/webjars/**","/swagger-resources/**","/v2/api-docs"};
//	private static final String[] EXCLUDE_PATHS = { "/user/**", "/error/**" };
	
	@Autowired
	private JwtInterceptor jwtInterceptor;

	@Autowired
	private JwtInterceptor2 jwtInterceptor2;
	
	//해당 페이지에 jwt 인터셉터 추가함으로써 토큰 없으면 접근 못하게끔 한다.
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(jwtInterceptor)
//		.addPathPatterns("/user/**", "/map/**", "/store/**")// 기본 적용 경로
//		.excludePathPatterns(Arrays.asList("/user/login/**","/user/register/**"));
//		
//		registry.addInterceptor(jwtInterceptor2)
//		.addPathPatterns("/notice/**");//기본 적용 경로
////		.excludePathPatterns(Arrays.asList("/user/login/**","/user/register/**"));
		
		
		//이거 안됨
//		registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/**", "/article/**", "/memo/**") // 기본 적용 경로
//        .excludePathPatterns(Arrays.asList("/user/confirm/**", "/article/list"));// 적용 제외 경로
	}

//  Interceptor를 이용해서 처리하므로 전역의 Cross Origin 처리를 해준다.
	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		default 설정.
//		Allow all origins.
//		Allow "simple" methods GET, HEAD and POST.
//		Allow all headers.
//		Set max age to 1800 seconds (30 minutes).
		registry.addMapping("/**")
			.allowedOrigins("*")
//			.allowedOrigins("http://localhost:8080", "http://localhost:8081")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//			.allowedHeaders("*")
			.maxAge(6000);
	}

	

}