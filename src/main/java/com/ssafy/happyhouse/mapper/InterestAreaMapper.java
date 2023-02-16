package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.InterestAreaDto;
import com.ssafy.happyhouse.dto.LikeDto;

@Mapper
public interface InterestAreaMapper {
	int chkInterest(InterestAreaDto interestAreaDto)throws SQLException;
	List<InterestAreaDto> selectInterest(String userId)throws SQLException;
	int insertInterest(InterestAreaDto interestAreaDto)throws SQLException;
	int deleteInterest(InterestAreaDto interestAreaDto)throws SQLException;
}