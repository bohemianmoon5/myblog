package com.day.myblog.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.day.myblog.dao.BoardDAO;
import com.day.myblog.dao.ReplyDAO;
import com.day.myblog.dto.Board;
import com.day.myblog.dto.Reply;
import com.day.myblog.exception.FindException;

@RestController
public class ReplyControllerTest {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@GetMapping("/test/board/{id}")
	public Board getBoard(@PathVariable int id) throws FindException {
		return boardDAO.selectById(id);
	}
	
	@GetMapping("/test/reply")
	public List<Reply> list(int boardId) throws FindException {
		return replyDAO.selectAll(boardId);
	}
}
