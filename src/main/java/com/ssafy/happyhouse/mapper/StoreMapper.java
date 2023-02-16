package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.StoreDto;

@Mapper
public interface StoreMapper {

	List<StoreDto> getStoreInDong(String dong) throws SQLException;
	
}
