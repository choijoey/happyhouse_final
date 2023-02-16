package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunDongCodeDto;
import com.ssafy.happyhouse.dto.StoreDto;

public interface StoreService {

	List<StoreDto> getStoreInDong(String dong) throws Exception;
}
