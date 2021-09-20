package com.day.myblog.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.day.myblog.exception.ModifyException;
import com.day.myblog.exception.RemoveException;
import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;
import com.day.myblog.exception.FindException;

public interface UserDAO {
	
	String insert(User user) throws AddException;
	
	User selectById(int id) throws FindException;
	
	List<User> selectAll() throws FindException;

	List<User> selectAll(int currentPage) throws FindException;
	
	String update(User user) throws ModifyException;
	
	String deleteById(int id) throws RemoveException;
	
	User selectByUsername(String username) throws FindException;

}
