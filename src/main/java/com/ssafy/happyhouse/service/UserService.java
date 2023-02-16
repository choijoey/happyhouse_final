package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserService {

	UserDto login(UserDto userDto) throws Exception;//
	UserDto userInfo(String userId) throws Exception;//
	int registerUser(UserDto userDto) throws Exception;//
	List<UserDto> listUser() throws Exception;
	int updateUser(UserDto userDto) throws Exception;
	int deleteUser(String userId) throws Exception;
	boolean userDuplicateChk(String userId) throws Exception;//
}
