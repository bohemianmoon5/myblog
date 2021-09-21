package com.day.myblog.dto;

import java.sql.Timestamp;
import java.util.List;

public class BoardBuilder {
	private int id;
	private String title;
	private String content;
	private int count;
	private int userid;
	private String username;
	private List<Reply> replys;
	private Timestamp createDate;
	
	public BoardBuilder setId(int id) {
		this.id = id;
		return this;
	}
	public BoardBuilder setTitle(String title) {
		this.title = title;
		return this;
	}
	public BoardBuilder setContent(String content) {
		this.content = content;
		return this;
	}
	public BoardBuilder setCount(int count) {
		this.count = count;
		return this;
	}
	public BoardBuilder setUserid(int userid) {
		this.userid = userid;
		return this;
	}
	public BoardBuilder setUsername(String username) {
		this.username = username;
		return this;
	}
	public BoardBuilder setReplys(List<Reply> replys) {
		this.replys = replys;
		return this;
	}
	public BoardBuilder setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
		return this;
	}
	public Board build() {
		return new Board(id, title, content, count, userid, username, replys, createDate);
	}
	
}
