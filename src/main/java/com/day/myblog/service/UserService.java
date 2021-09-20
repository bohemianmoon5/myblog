package com.day.myblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.day.myblog.dao.UserDAO;
import com.day.myblog.dto.User;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.ModifyException;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public int register(User user) {
		try {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			user.setPassword(encPassword);
			userDAO.insert(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : register() : " + e.getMessage());
		}
		return -1;
	}
	
	public User selectById(int id) throws FindException {
		return userDAO.selectById(id);
	}
	
	public int update(User user) throws FindException{
		User persistance = userDAO.selectById(user.getId());
		String check;
		try {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			persistance.setPassword(encPassword);
			persistance.setEmail(user.getEmail());
			check = userDAO.update(persistance);
			return 1;
		} catch (ModifyException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
//	public User login(User user) throws FindException {
//		User check = userDAO.selectByUsername(user.getUsername());
//		System.out.println(user.getUsername() + " : " + user.getPassword() +", DB[pwd] : " + check.getPassword());
//		if(!check.getPassword().equals(user.getPassword())) {
//			throw new FindException("로그인 실패!!");
//		}else {
//			return check;
//		}
//	}
}
