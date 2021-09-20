package com.day.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.day.myblog.dao.BoardDAO;
import com.day.myblog.dao.UserDAO;
import com.day.myblog.dto.Board;
import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.ModifyException;
import com.day.myblog.exception.RemoveException;
import com.day.myblog.utils.PagingVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public int write(Board board, User user) throws AddException {
		board.setUserid(user.getId());
		String check = boardDAO.insert(board);
		if(check != null) {
			return 1;
		}else {
			return -1;
		}
		
	}
	
	public List<Board> list(PagingVO vo) throws FindException {
		return boardDAO.selectAll(vo);
	}
	
	public int countBoard() {
		return boardDAO.CountBoard();
	}
	
	public Board seeDetail(int id) throws FindException {
		return boardDAO.selectById(id);
	}
	
	public int delete(int id) throws RemoveException {
		String check = boardDAO.deleteById(id);
		if(check != null) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public int update(int id, Board requestBoard) throws FindException, ModifyException {
		Board board = boardDAO.selectById(id);
		if(board != null) {
			board.setTitle(requestBoard.getTitle());
			board.setContent(requestBoard.getContent());
			boardDAO.update(board);
			return 1;
		}else {
			return -1;
		}
	}
}
