package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.ReplyDto;

@Mapper
public interface ReplyMapper {
	public List<ReplyDto> selectReply(int boardNo)throws SQLException;
	public int insertReply(ReplyDto replyDto)throws SQLException;
	public int deleteReply(int no)throws SQLException;
}