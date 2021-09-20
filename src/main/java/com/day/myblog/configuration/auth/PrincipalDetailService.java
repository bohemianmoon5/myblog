package com.day.myblog.configuration.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.day.myblog.dao.UserDAO;
import com.day.myblog.dto.User;
import com.day.myblog.exception.FindException;

@Service
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User principal = userDAO.selectByUsername(username);
			return new PrincipalDetail(principal);
		} catch (FindException e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("해당 유저를 찾을 수 없습니다. -> " + username);
		}
	}

	
}
