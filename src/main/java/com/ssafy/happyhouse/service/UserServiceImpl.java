package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDto login(UserDto userDto) throws Exception {
		System.out.println(userDto);
		if(userDto.getUserId()==null || userDto.getUserPassword()==null) {
			return null;
		}
		
		return userMapper.login(userDto);
	}

	@Override
	public UserDto userInfo(String userId) throws Exception {
		return userMapper.userInfo(userId);
	}

	@Override
	public int registerUser(UserDto userDto) throws Exception {
		return userMapper.registerUser(userDto);
	}

	@Override
	public List<UserDto> listUser() throws Exception {
		//회원 목록을 확인하기 전 관리자인지 확인
		return userMapper.listUser();
	}


	@Override
	@Transactional
	public int updateUser(UserDto userDto) throws Exception {
		return userMapper.updateUser(userDto); 
	}

	@Override
	@Transactional
	public int deleteUser(String userId) throws Exception {
		return userMapper.deleteUser(userId); 
	}

	@Override
	public boolean userDuplicateChk(String userId) throws Exception {
		
		int res = userMapper.userDuplicateChk(userId);
		
		//아이디 중복되면 false 반환
		if(res == 0)
			return true;
		else
			return false;
	}

	
}
