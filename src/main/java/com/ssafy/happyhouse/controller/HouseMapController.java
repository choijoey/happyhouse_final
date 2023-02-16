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
import com.ssafy.happyhouse.dto.PointDto;
import com.ssafy.happyhouse.dto.SidoGugunDongCodeDto;
import com.ssafy.happyhouse.service.HouseMapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/map")
@CrossOrigin("*")
@Api("HouseMapController V1")
public class HouseMapController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseMapService houseMapService;
	
	
	@GetMapping("/sido")
	@ApiOperation(value = "시/도", notes = "시/도 정보를 반환한다.", response = Map.class)
	public ResponseEntity<List<SidoGugunDongCodeDto>> sido() {
//		logger.debug("sido : {}", haHouseMapService.getSido());
		
		List<SidoGugunDongCodeDto> result = new ArrayList<SidoGugunDongCodeDto>();
		
		try {
			result = houseMapService.getSido();
			return new ResponseEntity<List<SidoGugunDongCodeDto>>(result, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<SidoGugunDongCodeDto>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/gugun")
	@ApiOperation(value = "구/군", notes = "구/군 정보를 반환한다.", response = Map.class)
	public ResponseEntity<List<SidoGugunDongCodeDto>> gugun(@RequestParam("sido") String sido) {
//		logger.debug("gugun : {}", haHouseMapService.getGugunInSido(sido));
		List<SidoGugunDongCodeDto> result = new ArrayList<SidoGugunDongCodeDto>();
		try {
			result = houseMapService.getGugunInSido(sido);
			return new ResponseEntity<List<SidoGugunDongCodeDto>>(result, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<SidoGugunDongCodeDto>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/dong")
	@ApiOperation(value = "동", notes = "동 정보를 반환한다.", response = Map.class)
	public ResponseEntity<List<SidoGugunDongCodeDto>> dong(@RequestParam("gugun") String gugun) {
		
		List<SidoGugunDongCodeDto> result = new ArrayList<SidoGugunDongCodeDto>();
		try {
			result =houseMapService.getDongInGugun(gugun);
			return new ResponseEntity<List<SidoGugunDongCodeDto>>(result, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<SidoGugunDongCodeDto>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/point")
	@ApiOperation(value = "위치 좌표", notes = "법정동 코드에 해당하는 위치 좌표를 반환한다.", response = Map.class)
	public ResponseEntity<PointDto> getPointInDong(@RequestParam("dongCode") String dongCode) {
		PointDto result = new PointDto();
		try {
			result = houseMapService.getPointInDong(dongCode);
			return new ResponseEntity<PointDto>(result, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<PointDto>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/apt")
	@ApiOperation(value = "아파트거래정보", notes = "아파트 거래 정보를 동으로 검색하여 정보를 반환한다.", response = Map.class)
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) {
		List<HouseInfoDto> result = new ArrayList<HouseInfoDto>();
		try {
			result = houseMapService.getAptInDong(dong);
			return new ResponseEntity<List<HouseInfoDto>>(result, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<HouseInfoDto>>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
