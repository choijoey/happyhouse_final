package com.ssafy.happyhouse.service;

import java.util.Map;

import com.ssafy.happyhouse.dto.UserDto;

public interface JwtService {

	<T> String create(UserDto userDto, String subject);
	boolean isUsable(String jwt);
	boolean chkAdmin(String jwt);
}
