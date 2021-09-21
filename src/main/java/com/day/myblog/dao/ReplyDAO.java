package com.day.myblog.dao;

import java.util.List;

import com.day.myblog.dto.Reply;
import com.day.myblog.exception.AddException;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.RemoveException;

public interface ReplyDAO {
	
	List<Reply> selectAll(int boardId) throws FindException;
	
	String insert(Reply reply) throws AddException;
	
	Reply selectById(int id) throws FindException;
	
	String deleteById(int id) throws RemoveException;

}
