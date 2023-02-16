package com.ssafy.happyhouse.dto;

public class InterestAreaDto {

	private int no;
	private String userId;
	private String date;
	private String dongCode;
	private String addr;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "InterestAreaDto [no=" + no + ", userId=" + userId + ", date=" + date + ", dongCode=" + dongCode
				+ ", addr=" + addr + "]";
	}
	
	
}
