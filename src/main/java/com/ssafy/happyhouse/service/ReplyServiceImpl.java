package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.ReplyDto;
import com.ssafy.happyhouse.mapper.BoardMapper;
import com.ssafy.happyhouse.mapper.ReplyMapper;


@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public List<ReplyDto> selectReply(int boardNo) throws Exception {
		return replyMapper.selectReply(boardNo);
	}

	@Override
	public int insertReply(ReplyDto replyDto) throws Exception {
		return replyMapper.insertReply(replyDto);
	}

	@Override
	@Transactional
	public int deleteReply(int no) throws Exception {
		return replyMapper.deleteReply(no);
	}
	
   
}