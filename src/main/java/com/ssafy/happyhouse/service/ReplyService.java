package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.ReplyDto;


public interface ReplyService {
	public List<ReplyDto> selectReply(int boardNo)throws Exception;
	public int insertReply(ReplyDto replyDto)throws Exception;
	public int deleteReply(int no)throws Exception;
}
