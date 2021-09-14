package com.day.myblog.dto;

import java.sql.Timestamp;
import java.util.List;

public class Board {
	private int id;
	private String title;
	private String content;
	private int count;
	private User user;
	private List<Reply> reply;
	private Timestamp createDate;
	
	public Board() {
		super();
	}
	
	public Board(int id, String title, String content, int count, User user, List<Reply> reply, Timestamp createDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.count = count;
		this.user = user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", count=" + count + ", user=" + user
				+ ", reply=" + reply + ", createDate=" + createDate + "]";
	}

}
