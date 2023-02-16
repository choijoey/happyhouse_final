package com.ssafy.happyhouse.dto;

import java.math.BigInteger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StoreDto : 가게 정보", description = "서울 가게들의 상세 정보(편의점/할인점/음식점)를 나타낸다.")
public class StoreDto {
	
	@ApiModelProperty(value = "가게Id")
	private int storeId;
	@ApiModelProperty(value = "가게 이름")
	private String storeName;
	@ApiModelProperty(value = "가게 상세 이름")
	private String storeSubName;
	@ApiModelProperty(value = "가게 대분류 코드")
	private String storeCode;
	@ApiModelProperty(value = "가게 대분류 코드 이름")
	private String storeCodeName;
	@ApiModelProperty(value = "가게 소분류 코드")
	private String storeSubCode;
	@ApiModelProperty(value = "가게 소분류 코드 이름")
	private String storeSubCodeName;
	@ApiModelProperty(value = "시/도 코드")
	private int sidoCode;
	@ApiModelProperty(value = "시/도 이름")
	private String sidoName;
	@ApiModelProperty(value = "구/군 코드")
	private int gugunCode;
	@ApiModelProperty(value = "구/군 이름")
	private String gugunName;
	@ApiModelProperty(value = "동 코드")
	private String dongCode;
	@ApiModelProperty(value = "동 이름")
	private String dongName;
	@ApiModelProperty(value = "법정동 코드")
	private String addressCode;	
	@ApiModelProperty(value = "건물 이름")
	private String buildingName;
	@ApiModelProperty(value = "주소")
	private String addressName;
	@ApiModelProperty(value = "우편번호")
	private String zipCode;
	@ApiModelProperty(value = "위도")
	private String lng;
	@ApiModelProperty(value = "경도")
	private String lat;
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreSubName() {
		return storeSubName;
	}
	public void setStoreSubName(String storeSubName) {
		this.storeSubName = storeSubName;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreCodeName() {
		return storeCodeName;
	}
	public void setStoreCodeName(String storeCodeName) {
		this.storeCodeName = storeCodeName;
	}
	public String getStoreSubCode() {
		return storeSubCode;
	}
	public void setStoreSubCode(String storeSubCode) {
		this.storeSubCode = storeSubCode;
	}
	public String getStoreSubCodeName() {
		return storeSubCodeName;
	}
	public void setStoreSubCodeName(String storeSubCodeName) {
		this.storeSubCodeName = storeSubCodeName;
	}
	public int getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public int getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "StoreDto [storeId=" + storeId + ", storeName=" + storeName + ", storeSubName=" + storeSubName
				+ ", storeCode=" + storeCode + ", storeCodeName=" + storeCodeName + ", storeSubCode=" + storeSubCode
				+ ", storeSubCodeName=" + storeSubCodeName + ", sidoCode=" + sidoCode + ", sidoName=" + sidoName
				+ ", gugunCode=" + gugunCode + ", gugunName=" + gugunName + ", dongCode=" + dongCode + ", dongName="
				+ dongName + ", addressCode=" + addressCode + ", buildingName=" + buildingName + ", addressName="
				+ addressName + ", zipCode=" + zipCode + ", lng=" + lng + ", lat=" + lat + "]";
	}
	
	
}
