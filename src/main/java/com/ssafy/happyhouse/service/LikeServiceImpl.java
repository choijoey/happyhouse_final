package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.LikeDto;
import com.ssafy.happyhouse.mapper.LikeMapper;

@Service
public class LikeServiceImpl implements LikeService{

	@Autowired
	private LikeMapper likeMapper;
	
	@Override
	public int chkLike(LikeDto likeDto) throws Exception {
		
		//이미 유저가 좋아요를 눌렀는지 먼저 구한다
		int resChk = likeMapper.chkLike(likeDto);
		
		if(resChk == 0) { // 체크안함
			likeMapper.insertLike(likeDto);
			return 1;
		}
		else {//이미 체크함 
			System.out.println(likeDto);
			likeMapper.deleteLike(likeDto);
			return -1;
		}
		
	}

	@Override
	public List<LikeDto> selectLike(int boardNo) throws Exception {
		return likeMapper.selectLike(boardNo) ;
	}

}
