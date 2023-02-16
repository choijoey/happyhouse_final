package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.NoticeDto;

@Mapper
public interface NoticeMapper {
	public List<NoticeDto> selectNotice();
	public NoticeDto selectNoticeByNo(int articleno);
	public int insertNotice(NoticeDto board);
	public int updateNotice(NoticeDto board);
	public int deleteNotice(int articleno);
}