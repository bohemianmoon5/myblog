package com.day.myblog.dto;

import java.sql.Timestamp;
import java.util.List;

public class Board {
	private int id;
	private String title;
	private String content;
	private int count;
	private int userid;
	private String username;
	private List<Reply> replys;
	//@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Timestamp createDate;
	//검색
	private String keyword;
	
	public Board() {
		super();
	}

	public Board(int id, String title, String content, int count, int userid, String username, List<Reply> replys,
			Timestamp createDate, String keyword) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.count = count;
		this.userid = userid;
		this.username = username;
		this.replys = replys;
		this.createDate = createDate;
		this.keyword = keyword;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", content=" + content + ", count=" + count + ", userid="
				+ userid + ", username=" + username + ", replys=" + replys + ", createDate=" + createDate + ", keyword="
				+ keyword + "]";
	}

}
