package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.ReplyDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.ReplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("ReplyController V1")
@RestController
@RequestMapping("/reply")
//@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class ReplyController {

	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private ReplyService replyService;

    @ApiOperation(value = "댓글 글목록", notes = "해당 글 번호에 해당하는 모든 댓글을 반환한다.", response = List.class)
	@PostMapping("{boardNo}")
	public ResponseEntity<List<ReplyDto>> selectReply(
			@PathVariable 
			@ApiParam(value = "해당 글에 해당하는 댓글을 불러오기 위한 글 번호", required = true) 
			int boardNo){
		logger.debug("selectReply - 호출");
		List<ReplyDto> result = new ArrayList<ReplyDto>();
		try {
			result=replyService.selectReply(boardNo);
			return new ResponseEntity<List<ReplyDto>>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ReplyDto>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


    @ApiOperation(value = "댓글 등록", notes = "새로운 댓글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertReply(@RequestBody ReplyDto replyDto) {
		logger.debug("writeBoard - 호출");
		
		int result =0;
		
		try {
			result = replyService.insertReply(replyDto);
			
			if (result==1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    

    @ApiOperation(value = "댓글 삭제", notes = "글번호에 해당하는 댓글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteReply(@PathVariable int no) {
		logger.debug("deleteBoard - 호출");
		int result =0;
		try {
			result=replyService.deleteReply(no);
			if (result==1) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}