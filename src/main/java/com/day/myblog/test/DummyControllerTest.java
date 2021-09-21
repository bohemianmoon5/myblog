package com.day.myblog.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.day.myblog.dao.BoardDAO;
import com.day.myblog.dao.UserDAO;
import com.day.myblog.dto.Board;
import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.ModifyException;
import com.day.myblog.exception.RemoveException;
import com.day.myblog.utils.PagingVO;

@RestController
public class DummyControllerTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) throws RemoveException {
		return userDAO.deleteById(id);
	}
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) throws ModifyException {
		System.out.println("id : " + id);
		System.out.println("password : " + requestUser.getPassword());
		System.out.println("email : " + requestUser.getEmail());
		requestUser.setId(id);
		userDAO.update(requestUser);
		return null;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list() throws FindException {
		return userDAO.selectAll();
	}
	
	//test용으로 값을 직접 입력함.
	@GetMapping("/dummy/user")
	public List<User> pageList() throws FindException {
		List<User> users = userDAO.selectAll(1);
		return users;
	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) throws FindException {
		User user = userDAO.selectById(id);
		return user;
		
	}
	
	@PostMapping("/dummy/join")
	public String join(User user) throws AddException {
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		return userDAO.insert(user);
	}
	
	@GetMapping("/dummy/board")
	public List<Board> boardList(PagingVO vo) throws FindException {
		vo = new PagingVO(7, 1, 6);
		List<Board> boards = boardDAO.selectAll(vo);
		return boards;
	}
	
	@GetMapping("/dummy/board/{id}")
	public Board boardDetail(@PathVariable int id) throws FindException {
		Board board = boardDAO.selectById(id);
		return board;
	}
	

}
