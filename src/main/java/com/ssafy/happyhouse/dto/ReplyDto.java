package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReplyDto : 댓글 정보", description = "댓글 정보를 나타낸다.")
public class ReplyDto {


	@ApiModelProperty(value = "댓글 키값 번호")
	private int no;
	@ApiModelProperty(value = "게시판의 키값 (FK)")
	private int boardNo;
	@ApiModelProperty(value = "유저 아이디")
	private String userId;
	@ApiModelProperty(value = "댓글 내용")
	private String content;
	@ApiModelProperty(value = "댓글 작성 시간")
	private String date;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ReplyDto [no=" + no + ", boardNo=" + boardNo + ", userId=" + userId + ", content=" + content + ", date="
				+ date + "]";
	}
	
	
}
