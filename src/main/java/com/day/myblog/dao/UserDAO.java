package com.day.myblog.dao;

import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;

public interface UserDAO {
	
	void insert(User user) throws AddException;

}
