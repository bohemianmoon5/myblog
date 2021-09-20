package com.day.myblog.dto;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Board {
	private int id;
	private String title;
	private String content;
	private int count;
	private int userid;
	private List<Reply> reply;
	//@JsonFormat(pattern = "yy/MM/dd", timezone = "Asia/Seoul")
	private Timestamp createDate;
	
	public Board() {
		super();
	}
	
	public Board(int id, String title, String content, int count, int userid, List<Reply> reply, Timestamp createDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.count = count;
		this.userid = userid;
		this.reply = reply;
		this.createDate = createDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public List<Reply> getReply() {
		return reply;
	}
	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", count=" + count + ", userid="
				+ userid + ", reply=" + reply + ", createDate=" + createDate + "]";
	}

}