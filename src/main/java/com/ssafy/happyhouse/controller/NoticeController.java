package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.NoticeDto;
import com.ssafy.happyhouse.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("NoticeController V1")
@RestController
@RequestMapping("/notice")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private NoticeService noticeService;

    @ApiOperation(value = "공지사항 글목록", notes = "모든 공지사항의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<NoticeDto>> selectNotice() {
		logger.debug("selectNotice - 호출");
		return new ResponseEntity<List<NoticeDto>>(noticeService.selectNotice(), HttpStatus.OK);
	}

    @ApiOperation(value = "공지사항 글보기", notes = "글번호에 해당하는 공지사항의 정보를 반환한다.", response = NoticeDto.class)    
	@GetMapping("{no}")
	public ResponseEntity<NoticeDto> selectNoticeByNo(
			@PathVariable 
			@ApiParam(value = "공지사항 입력시 필요한 공지사항 글 번호.", required = true) 
			int no) {
		logger.debug("selectNoticeByNo - 호출");
		return new ResponseEntity<NoticeDto>(noticeService.selectNoticeByNo(no), HttpStatus.OK);
	}

    @ApiOperation(value = "공지사항 글등록", notes = "title content 만 추가 가능 !!새로운 공지사항 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeBoard(
			@RequestBody 
			@ApiParam(value = "NoticeDto", required = true)
			NoticeDto noticeDto) {
		logger.debug("writeBoard - 호출");
		
		if (noticeService.insertNotice(noticeDto) == 1 ) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "공지사항 글정보 수정", notes = "title content 만 추가 가능 !! 글번호에 해당하는 공지사항의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> updateBoard(
			@RequestBody 
			@ApiParam(value = "NoticeDto", required = true)
			NoticeDto noticeDto) {
		logger.debug("updateBoard - 호출");
		
		if (noticeService.updateNotice(noticeDto) ==1 ) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "공지사항 글삭제", notes = "공지사항에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteBoard(
			@PathVariable 
			@ApiParam(value = "글삭제할 공지사항 글 번호", required = true)
			int no) {
		logger.debug("deleteBoard - 호출");
		if (noticeService.deleteNotice(no) ==1 ) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}