package com.day.myblog.dto;

import java.sql.Timestamp;

public class ReplyBuilder {
	private int id;
	private String content;
	private int boardid;
	private int userid;
	private String username;
	private Timestamp createDate;
	
	public ReplyBuilder setId(int id) {
		this.id = id;
		return this;
	}
	public ReplyBuilder setContent(String content) {
		this.content = content;
		return this;
	}
	public ReplyBuilder setBoard(int boardid) {
		this.boardid = boardid;
		return this;
	}
	public ReplyBuilder setUser(int userid) {
		this.userid = userid;
		return this;
	}
	public ReplyBuilder setUsername(String username) {
		this.username = username;
		return this;
	}
	public ReplyBuilder setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
		return this;
	}
	public Reply build() {
		return new Reply(id, content, boardid, userid, username, createDate);
	}
	
}
