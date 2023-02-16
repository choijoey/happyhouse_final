package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseInfoDto;
import com.ssafy.happyhouse.dto.PointDto;
import com.ssafy.happyhouse.dto.SidoGugunDongCodeDto;

@Mapper
public interface HouseMapMapper {

	List<SidoGugunDongCodeDto> getSido() throws SQLException;
	List<SidoGugunDongCodeDto> getGugunInSido(String sido) throws SQLException;
	List<SidoGugunDongCodeDto> getDongInGugun(String gugun) throws SQLException;
	PointDto getPointInDong(String dongCode) throws SQLException;
	List<HouseInfoDto> getAptInDong(String dong) throws SQLException;
	
}
