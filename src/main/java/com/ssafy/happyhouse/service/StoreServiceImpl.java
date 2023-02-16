package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.StoreDto;
import com.ssafy.happyhouse.mapper.StoreMapper;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreMapper storeMapper;

	@Override
	public List<StoreDto> getStoreInDong(String dong) throws Exception {
		return storeMapper.getStoreInDong(dong);
	}


}
