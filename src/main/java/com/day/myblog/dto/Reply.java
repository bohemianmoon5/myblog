package com.day.myblog.dto;

import java.sql.Timestamp;

public class Reply {
	private int id;
	private String content;
	private Board board;
	private User user;
	private Timestamp createDate;
	
	public Reply() {
		super();
	}

	public Reply(int id, String content, Board board, User user, Timestamp createDate) {
		super();
		this.id = id;
		this.content = content;
		this.board = board;
		this.user = user;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", content=" + content + ", board=" + board + ", user=" + user + ", createDate="
				+ createDate + "]";
	}
	
}
