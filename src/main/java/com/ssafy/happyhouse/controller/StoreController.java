package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunDongCodeDto;
import com.ssafy.happyhouse.dto.StoreDto;
import com.ssafy.happyhouse.service.HouseMapService;
import com.ssafy.happyhouse.service.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/store")
@CrossOrigin("*")
@Api("StoreController V1")

public class StoreController {
	
	private final Logger logger = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	private StoreService storeService;
	

	
	@GetMapping("/apt")
	@ApiOperation(value = "상점 정보", notes = "상점 정보를 동으로 검색하여 정보를 반환한다.", response = Map.class)
	public ResponseEntity<List<StoreDto>> apt(@RequestParam("dong") String dong) {
		
		List<StoreDto> result = new ArrayList<StoreDto>();
		try {
			result=storeService.getStoreInDong(dong);
			return new ResponseEntity<List<StoreDto>>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<StoreDto>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
