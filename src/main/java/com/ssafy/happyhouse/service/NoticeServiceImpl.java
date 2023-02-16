package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.NoticeDto;
import com.ssafy.happyhouse.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<NoticeDto> selectNotice() {
		return noticeMapper.selectNotice();
	}

	@Override
	public NoticeDto selectNoticeByNo(int articleno) {
		return noticeMapper.selectNoticeByNo(articleno);
	}

	@Override
	public int insertNotice(NoticeDto board) {
		return noticeMapper.insertNotice(board);
	}

	@Override
	@Transactional
	public int updateNotice(NoticeDto board) {
		return noticeMapper.updateNotice(board);
	}

	@Override
	@Transactional
	public int deleteNotice(int articleno) {
		return noticeMapper.deleteNotice(articleno);
	}
	

}