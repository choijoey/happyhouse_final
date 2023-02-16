package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
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

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.dto.LikeDto;
import com.ssafy.happyhouse.dto.ReplyDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.LikeService;
import com.ssafy.happyhouse.service.ReplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("LikeController V1")
@RestController
@RequestMapping("/like")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class LikeController {

	private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private LikeService likeService;

    @ApiOperation(value = "댓글 글목록", notes = "해당 글에 해당하는 좋아요들을반환한다.", response = List.class)
	@PostMapping("{boardNo}")
	public ResponseEntity<List<LikeDto>> selectLike(
			@PathVariable 
			@ApiParam(value = "해당 글에 해당하는 좋아요들을 불러오기 위한 글 번호", required = true) 
			int boardNo){
		logger.debug("selectLike - 호출");
		List<LikeDto> result = new ArrayList<LikeDto>();
		try {
			result=likeService.selectLike(boardNo);
			return new ResponseEntity<List<LikeDto>>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<LikeDto>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


    @ApiOperation(value = "좋아요 클릭", notes = "클릭시 좋아요 // 다시 클릭시 좋아요 해제 ",response = String.class)
	@PostMapping
	public ResponseEntity<String> chkLike(@RequestBody LikeDto likeDto) {
		logger.debug("insertReply - 호출");
		
		int result =0;
		
		try {
			result = likeService.chkLike(likeDto);
			
			if (result==1) {
				return new ResponseEntity<String>(SUCCESS+result, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>(SUCCESS+result, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}