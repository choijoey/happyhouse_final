package com.ssafy.happyhouse.dto;

import java.math.BigInteger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HouseInfoDto :아파트 정보(거래 정보)", description = "아파트 거래 정보 Dto")
public class HouseInfoDto {
	
	@ApiModelProperty(value = "거래 정보를 구분 짓기 위한 키값")
	private BigInteger no;
	@ApiModelProperty(value = "아파트 코드")
	private BigInteger aptCode;
	@ApiModelProperty(value = "아파트 이름")
	private String aptName;
	@ApiModelProperty(value = "법정동 코드")
	private String dongCode;
	@ApiModelProperty(value = "동 이름")
	private String dong;
	@ApiModelProperty(value = "아파트 주소")
	private String addr;
	@ApiModelProperty(value = "건축 년도")
	private int buildYear;
	@ApiModelProperty(value = "전용 면적")
	private String area;
	@ApiModelProperty(value = "층수")
	private String floor;
	@ApiModelProperty(value = "거래 날짜")
	private String dealDate;
	@ApiModelProperty(value = "거래 금액")
	private String dealAmount;
	@ApiModelProperty(value = "위도")
	private String lat;
	@ApiModelProperty(value = "경도")
	private String lng;
	@ApiModelProperty(value = "이미지파일")
	private String img;
	public BigInteger getNo() {
		return no;
	}
	public void setNo(BigInteger no) {
		this.no = no;
	}
	public BigInteger getAptCode() {
		return aptCode;
	}
	public void setAptCode(BigInteger aptCode) {
		this.aptCode = aptCode;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "HouseInfoDto [no=" + no + ", aptCode=" + aptCode + ", aptName=" + aptName + ", dongCode=" + dongCode
				+ ", dong=" + dong + ", addr=" + addr + ", buildYear=" + buildYear + ", area=" + area + ", floor="
				+ floor + ", dealDate=" + dealDate + ", dealAmount=" + dealAmount + ", lat=" + lat + ", lng=" + lng
				+ ", img=" + img + "]";
	}
	




}
