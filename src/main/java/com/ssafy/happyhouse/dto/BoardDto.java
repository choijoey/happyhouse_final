package com.ssafy.happyhouse.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoardDto (게시글정보)", description = "글번호, 제목, 내용, 작성자아이디, 작성일,img   Domain Class")
public class BoardDto {
	@ApiModelProperty(value = "글번호")
	private int no;
	@ApiModelProperty(value = "작성자아이디")
	private String userId;
	@ApiModelProperty(value = "제목")
	private String title;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String date;
	@ApiModelProperty(value = "작성일")
	private String img;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", userId=" + userId + ", title=" + title + ", content=" + content + ", date="
				+ date + ", img=" + img + "]";
	}


	
}