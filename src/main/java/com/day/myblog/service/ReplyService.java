package com.day.myblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day.myblog.dao.ReplyDAO;
import com.day.myblog.dto.Reply;
import com.day.myblog.exception.FindException;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	public List<Reply> list(int boardId) throws FindException {
		return replyDAO.selectAll(boardId);
	}
	
	public Reply selectById(int id) throws FindException {
		return replyDAO.selectById(id);
	}

}
