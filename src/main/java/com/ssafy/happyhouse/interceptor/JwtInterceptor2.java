package com.ssafy.happyhouse.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.happyhouse.exception.UnauthorizedException;
import com.ssafy.happyhouse.service.JwtService;

@Component
public class JwtInterceptor2 implements HandlerInterceptor{
	
	//인터셉터에 추가함으로써 모든 페이지에 접근할때 로그인 정보가 필요함
	
	public static final Logger logger = LoggerFactory.getLogger(JwtInterceptor2.class);

	//헤더의 권한
	private static final String HEADER_AUTH = "access-token";

	@Autowired
	private JwtService jwtService;

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);

		//요청 URL이 외부 도메인일 경우 웹 브라우저는 preflight 요청을 먼저 날린다.
		//preflight 요청은 실제로 요청하려는 경로와 같은 URL에 대해 OPTIONS 메소드를 미리 날려 요청할 수 있는 권한이 있는지 확인한다. 
		//서버로 넘어온 preflight  요청을 처리하여 웹 브라우저에서 실제 요청을 날릴 수 있도록 접근 허용 설정을 해줘야 한다. 
		//권한이 없으면 에러를 발생시키고 권한이 있으면 실제 요청을 처리 해준다.
		//https://codediver.tistory.com/135
		
		if(request.getMethod().equals("OPTIONS")) {
			return true;
		}

		if(token != null && jwtService.chkAdmin(token)){
			logger.info("토큰 사용 가능 : {}", token);
			return true;
		}else{
			logger.info("토큰 사용 불가능 : {}", token);
			throw new UnauthorizedException();
		}

	}
}
