package com.day.myblog.dto;

import java.sql.Timestamp;

public class UserBuilder {
	private int id;
	private String username;
	private String password;
	private String email;
	private String role;
	private String oauth;
	private Timestamp createDate;
	
	public UserBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public UserBuilder setUsername(String username) {
		this.username = username;
		return this;
	}

	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public UserBuilder setRole(String role) {
		this.role = role;
		return this;
	}
	
	public UserBuilder setOauth(String oauth) {
		this.oauth = oauth;
		return this;
	}

	public UserBuilder setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
		return this;
	}

	public User build() {
		return new User(id, username, password, email, role, oauth, createDate);
	}

}
