package com.ssafy.happyhouse.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.exception.UnauthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {

	public static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

	//비밀 키
	private static final String SALT = "sugar";
	
	//유통기한 60분
	private static final int EXPIRE_MINUTES = 60;

	
	// 데이터를 받아서 String 토큰을 발급해준다
	//setHeaderParam 헤더에 정보 넣기
	//setExpiration 유효기간
	//payload 입력한다.
	//서명 하고 compact 해서 문자열로 만들어준다
	@Override
	public <T> String create(UserDto userDto, String subject) {
		System.out.println("subject: "+subject);
		System.out.println("userDto: "+userDto);
		
		String role="";
		
		if(userDto.getIsAdmin().equals("0"))
			role = "일반회원";
		else
			role="관리자";
		
		String jwt = Jwts.builder()
				.setHeaderParam("alg","HS256")
				.setHeaderParam("typ", "JWT")
				.setHeaderParam("regDate", System.currentTimeMillis())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * EXPIRE_MINUTES))
				.setSubject(subject)
				.claim("role", role)
				.claim("userId", userDto.getUserId())
				.signWith(SignatureAlgorithm.HS256, this.generateKey())
				.compact();
		return jwt;
	}

	private byte[] generateKey() {
		byte[] key = null;
		try {
			key = SALT.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			if (logger.isInfoEnabled()) {
				e.printStackTrace();
			} else {
				logger.error("Making JWT Key Error ::: {}", e.getMessage());
			}
		}

		return key;
	}

	//	전달 받은 토큰이 제대로 생성된것인지 확인 하고 문제가 있다면 UnauthorizedException을 발생.
	//토큰을 받고 이 토큰이 유효하지 않으면 catch로 runtime error잡음
	//토큰이 유효한지 확인하는 함수
	@Override
	public boolean isUsable(String jwt) {
		try {
			System.out.println(jwt);
			Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
//			System.out.println("claims"+claims);
//			String role = (String) claims.getBody().get("role");
//			System.out.println("role : "+role);
			return true;
		} catch (Exception e) {
//			if (logger.isInfoEnabled()) {
//				e.printStackTrace();
//			} else {
			logger.error(e.getMessage());
//			}
//			throw new UnauthorizedException();
//			개발환경
			return false;
		}
	}

	//해당 토큰의 헤더에 role 값이 관리자인지 확인!!
	
	@Override
	public boolean chkAdmin(String jwt) {
		try {
			System.out.println(jwt);
			Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
			String role = (String) claims.getBody().get("role");
			
			if(role.equals("관리자"))
				return true;
//			System.out.println("role : "+role);
//			System.out.println(role.equals("관리자"));
			return false;
		} catch (Exception e) {
//			if (logger.isInfoEnabled()) {
//				e.printStackTrace();
//			} else {
			logger.error(e.getMessage());
//			}
//			throw new UnauthorizedException();
//			개발환경
			return false;
		}
	}
	



}
