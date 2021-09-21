package com.day.myblog.dto;

import java.sql.Timestamp;

public class Reply {
	private int id;
	private String content;
	private int boardid;
	private int userid;
	private String username;
	private Timestamp createDate;
	
	public Reply() {
		super();
	}

	public Reply(int id, String content, int boardid, int userid, String username, Timestamp createDate) {
		super();
		this.id = id;
		this.content = content;
		this.boardid = boardid;
		this.userid = userid;
		this.username = username;
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

	public int getBoardid() {
		return boardid;
	}

	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Reply [id=" + id + ", content=" + content + ", boardid=" + boardid + ", userid=" + userid
				+ ", username=" + username + ", createDate=" + createDate + "]";
	}

}
