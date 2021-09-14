package com.day.myblog.dto;

import java.sql.Timestamp;

public class ReplyBuilder {
	private int id;
	private String content;
	private Board board;
	private User user;
	private Timestamp createDate;
	
	public ReplyBuilder setId(int id) {
		this.id = id;
		return this;
	}
	public ReplyBuilder setContent(String content) {
		this.content = content;
		return this;
	}
	public ReplyBuilder setBoard(Board board) {
		this.board = board;
		return this;
	}
	public ReplyBuilder setUser(User user) {
		this.user = user;
		return this;
	}
	public ReplyBuilder setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
		return this;
	}
	public Reply build() {
		return new Reply(id, content, board, user, createDate);
	}
	
}
