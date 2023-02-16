package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.InterestAreaDto;
import com.ssafy.happyhouse.dto.LikeDto;

public interface InterestAreaService {
	int chkInterest(InterestAreaDto interestAreaDto)throws Exception;
	List<InterestAreaDto> selectInterest(String userId)throws Exception;
}
