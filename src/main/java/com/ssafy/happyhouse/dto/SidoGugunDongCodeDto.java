package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SidoGugunDongCodeDto :시도구군 코드값", description = "시/도 구/군 동 코드값.")
public class SidoGugunDongCodeDto {

	@ApiModelProperty(value = "시/도 코드값")
	private String sidoCode;
	@ApiModelProperty(value = "시/도 이름")
	private String sidoName;
	@ApiModelProperty(value = "구/군 코드값")
	private String gugunCode;
	@ApiModelProperty(value = "구/군 이름")
	private String gugunName;
	@ApiModelProperty(value = "동 코드값")
	private String dongCode;
	@ApiModelProperty(value = "동 이름")
	private String dongName;
	public String getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(String sidoCode) {
		this.sidoCode = sidoCode;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public String getGugunCode() {
		return gugunCode;
	}
	public void setGugunCode(String gugunCode) {
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
	@Override
	public String toString() {
		return "SidoGugunDongCodeDto [sidoCode=" + sidoCode + ", sidoName=" + sidoName + ", gugunCode=" + gugunCode
				+ ", gugunName=" + gugunName + ", dongCode=" + dongCode + ", dongName=" + dongName + "]";
	}
	
}
