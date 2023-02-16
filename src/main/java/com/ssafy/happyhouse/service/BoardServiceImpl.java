package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.mapper.BoardMapper;


@Service
public class BoardServiceImpl implements BoardService {
	
    @Autowired
	private BoardMapper boardMapper;

    @Override
	public List<BoardDto> retrieveBoard() throws Exception {
		return boardMapper.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(BoardDto boardDto) throws Exception{
		return boardMapper.insertBoard(boardDto) == 1;
	}

	@Override
	public BoardDto detailBoard(int no) throws Exception{
		return boardMapper.selectBoardByNo(no);
	}
	
	@Override
	@Transactional
	public boolean updateBoard(BoardDto boardDto)throws Exception{
		return boardMapper.updateBoard(boardDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no)throws Exception {
		boardMapper.deleteReplyInBoard(no);
		
		return boardMapper.deleteBoard(no) == 1;
	}
}