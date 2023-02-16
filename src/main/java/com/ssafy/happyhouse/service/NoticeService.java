package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.NoticeDto;


public interface NoticeService {
	List<NoticeDto> selectNotice();
	NoticeDto selectNoticeByNo(int articleno);
	int insertNotice(NoticeDto board);
	int updateNotice(NoticeDto board);
	int deleteNotice(int articleno);
}
