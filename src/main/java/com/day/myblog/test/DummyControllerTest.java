package com.day.myblog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.day.myblog.dao.UserDAO;
import com.day.myblog.dto.RoleType;
import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;

@RestController
public class DummyControllerTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@PostMapping("/dummy/join")
	public String join(User user) throws AddException {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		userDAO.insert(user);
		return "회원가입이 완료되었습니다.";
	}

}
