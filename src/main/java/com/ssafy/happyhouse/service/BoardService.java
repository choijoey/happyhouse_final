package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.BoardDto;


public interface BoardService {
	List<BoardDto> retrieveBoard() throws Exception;
	BoardDto detailBoard(int no) throws Exception;
	boolean writeBoard(BoardDto boardDto) throws Exception;
	boolean updateBoard(BoardDto boardDto) throws Exception;
	boolean deleteBoard(int no) throws Exception;
}
