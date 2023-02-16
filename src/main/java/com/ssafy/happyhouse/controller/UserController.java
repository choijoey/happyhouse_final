package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.service.JwtServiceImpl;
import com.ssafy.happyhouse.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("MemberController V1")
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtServiceImpl jwtService;

	@Autowired
	private UserService userService;

	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메세지를 반환한다.", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody 
			@ApiParam(value = "로그인 시 필요한 회원정보(아이디, 비밀번호).", required = true) 
			UserDto userDto) {
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		// user 실제 DB에서 검증해야됨
		// UserService 불러서 UserDao를 불러 DB통신한다음 결과 얻어옴
		//이게 만약에 존재한다면 => 토큰 생성해서 결과를 넣은다음 반환
		
		try {
			UserDto loginUser = userService.login(userDto);
			if (loginUser != null) {
				String token = jwtService.create(loginUser, "access-token");// key,subject
				logger.debug("로그인 토큰정보 : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		} 
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userId}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userId") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userId,
			HttpServletRequest request) {
//		logger.debug("userid : {} ", userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println(request.getHeader("access-token"));
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				UserDto userDto = userService.userInfo(userId);
				resultMap.put("userInfo", userDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("정보조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	
	@ApiOperation(value = "회원가입", response = Map.class)
	@PostMapping("/user")
	public ResponseEntity<Integer> registerUser(
			@RequestBody
			@ApiParam(value = "인증할 회원의 아이디.", required = true)
			UserDto userDto) {
		
		HttpStatus status = HttpStatus.ACCEPTED;
		int result=-1;
		
			try {
				result= userService.registerUser(userDto);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("회원가입 실패 : {}", e);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}

		return new ResponseEntity<Integer>(result, status);
	}
	
	@ApiOperation(value = "아이디 중복 체크", response = Map.class)
	@GetMapping("/idcheck/{userId}")
	public ResponseEntity<Map<String, Object>> userDuplicateChk(
			@PathVariable("userId")
			@ApiParam(value = "중복 체크할 아이디", required = true)
			String userId) {
		
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
			try {
				System.out.println(userId);
				Boolean result = userService.userDuplicateChk(userId);
				
				if(result) {//중복 없음
					resultMap.put("result", "성공");
					resultMap.put("message", SUCCESS);
				}
				else {
					resultMap.put("result", "아이디가 중복입니다");
					resultMap.put("message", FAIL);
				}
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("중복체크 실패 : {}", e);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}

		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원정보수정", notes = "주의 :이름/비밀번호/이메일만 가능합니다!!!!")
	@PutMapping(value = "/user")
	public ResponseEntity<Integer> updateUser(
			@RequestBody
			@ApiParam(value = "수정할 아이디", required = true)
			UserDto userDto) {
		
		HttpStatus status = HttpStatus.ACCEPTED;
		int result=-1;
		
			try {
				result= userService.updateUser(userDto);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("회원수정 실패 : {}", e);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}

		return new ResponseEntity<Integer>(result, status);
	}
	
	@ApiOperation(value = "회원정보삭제", notes = "회원정보를 삭제합니다")
	@DeleteMapping(value = "/user/{userId}")
	public ResponseEntity<Integer> deleteUser(
			@PathVariable("userId")
			@ApiParam(value = "삭제할 아이디", required = true)
			String userId) {
		
		HttpStatus status = HttpStatus.ACCEPTED;
		int result=-1;
		
			try {
				result= userService.deleteUser(userId);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("회원삭제 실패 : {}", e);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}

		return new ResponseEntity<Integer>(result, status);
	}
	
	@ApiOperation(value = "회원정보 리스트", notes = "회원정보를 불러옵니다")
	@GetMapping(value = "/list")
	public ResponseEntity<List<UserDto>> listUser(){
		
		HttpStatus status = HttpStatus.ACCEPTED;
		List<UserDto> result = new ArrayList<>();
		
		try {
			result=userService.listUser();
			
		}catch(Exception e) {
			logger.error("회원리스트 실패 : {}", e);
			status = HttpStatus.INTERNAL_SERVER_ERROR; 
		}
		return new ResponseEntity<List<UserDto>>( result,status);
	
}

}
