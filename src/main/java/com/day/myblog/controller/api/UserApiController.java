package com.day.myblog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.day.myblog.dto.ResponseDto;
import com.day.myblog.dto.User;
import com.day.myblog.exception.FindException;
import com.day.myblog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출됨.");
		int result = userService.register(user);
		if(result == 1) {
			return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
		}else {
			return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), result);
		}
		
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user) throws FindException {
		int result = userService.update(user);
		if(result == 1) {
			//세션등록
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
		}else {
			return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), result);
		}
	}
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) throws FindException {
//		System.out.println("UserApiController : login 호출됨.");
//		User principal = userService.login(user);
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//			return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//		}else {
//			return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), -1);
//		}
//		
//	}
	
}
