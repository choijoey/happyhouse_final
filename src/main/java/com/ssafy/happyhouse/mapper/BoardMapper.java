package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.happyhouse.dto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoard()throws SQLException;
	BoardDto selectBoardByNo(int no)throws SQLException;
	int insertBoard(BoardDto boardDto)throws SQLException;
	int updateBoard(BoardDto boardDto)throws SQLException;
	int deleteBoard(int no)throws SQLException;
	int deleteReplyInBoard(int no)throws SQLException;
}