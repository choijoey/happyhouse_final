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
import com.ssafy.happyhouse.dto.InterestAreaDto;
import com.ssafy.happyhouse.dto.LikeDto;
import com.ssafy.happyhouse.dto.ReplyDto;
import com.ssafy.happyhouse.service.BoardService;
import com.ssafy.happyhouse.service.InterestAreaService;
import com.ssafy.happyhouse.service.LikeService;
import com.ssafy.happyhouse.service.ReplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api("InterestAreaController V1")
@RestController
@RequestMapping("/interest")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class InterestAreaController {

	private static final Logger logger = LoggerFactory.getLogger(InterestAreaController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private InterestAreaService interestAreaService;

    @ApiOperation(value = "찜한 동네 목록 ", notes = "찜한 동네 목록 반환 .", response = List.class)
	@PostMapping("{userId}")
	public ResponseEntity<List<InterestAreaDto>> selectInterest(
			@PathVariable 
			String userId){
    	
		List<InterestAreaDto> result = new ArrayList<>();
		try {
			result=interestAreaService.selectInterest(userId);
			return new ResponseEntity<List<InterestAreaDto>>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<InterestAreaDto>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


    @ApiOperation(value = "찜 클릭", notes = "찜  // 다시 클릭시 찜 해제 ",response = String.class)
	@PostMapping
	public ResponseEntity<String> chkLike(@RequestBody InterestAreaDto interestAreaDto) {
		
		int result =0;
		
		try {
			result = interestAreaService.chkInterest(interestAreaDto);
			
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