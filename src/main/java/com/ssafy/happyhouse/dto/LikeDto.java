package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReplyDto : 좋아요!!", description = "좋아요 표시를 나타낸다")
public class LikeDto {

	

	@ApiModelProperty(value = "게시판 키값 (FK)")
	private int boardNo;
	@ApiModelProperty(value = "유저 아이디")
	private String userId;
	@ApiModelProperty(value = "날짜")
	private String date;

	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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
	@Override
	public String toString() {
		return "LikeDto [boardNo=" + boardNo + ", userId=" + userId + ", date=" + date + "]";
	}
	
	
	
}
