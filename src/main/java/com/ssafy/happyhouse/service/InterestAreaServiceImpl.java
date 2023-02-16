package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.InterestAreaDto;
import com.ssafy.happyhouse.dto.LikeDto;
import com.ssafy.happyhouse.mapper.InterestAreaMapper;
import com.ssafy.happyhouse.mapper.LikeMapper;

@Service
public class InterestAreaServiceImpl implements InterestAreaService{

	@Autowired
	private InterestAreaMapper interestAreaMapper;
	
	
	@Override
	public int chkInterest(InterestAreaDto interestAreaDto) throws Exception {
		//이미 유저가 좋아요를 눌렀는지 먼저 구한다
		int resChk = interestAreaMapper.chkInterest(interestAreaDto);
		
		if(resChk == 0) { // 체크안함
			interestAreaMapper.insertInterest(interestAreaDto);
			return 1;
		}
		else {//이미 체크함 
			System.out.println(interestAreaDto);
			interestAreaMapper.deleteInterest(interestAreaDto);
			return -1;
		}

	}

	@Override
	public List<InterestAreaDto> selectInterest(String userId) throws Exception {
		return interestAreaMapper.selectInterest(userId) ;
	}

}
