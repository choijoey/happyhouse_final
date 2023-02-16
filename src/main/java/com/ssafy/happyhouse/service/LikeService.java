package com.ssafy.happyhouse.service;

import java.util.List;


import com.ssafy.happyhouse.dto.LikeDto;

public interface LikeService {

	int chkLike(LikeDto likeDto) throws Exception;
	List<LikeDto> selectLike(int boardNo)throws Exception;
}
