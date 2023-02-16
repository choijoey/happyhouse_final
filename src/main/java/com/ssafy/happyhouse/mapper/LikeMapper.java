package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.LikeDto;

@Mapper
public interface LikeMapper {
	int chkLike(LikeDto likeDto)throws SQLException;
	List<LikeDto> selectLike(int boardNo)throws SQLException;
	int insertLike(LikeDto likeDto)throws SQLException;
	int deleteLike(LikeDto likeDto)throws SQLException;
}