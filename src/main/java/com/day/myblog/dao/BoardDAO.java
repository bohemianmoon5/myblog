package com.day.myblog.dao;

import java.util.List;

import com.day.myblog.dto.Board;
import com.day.myblog.exception.AddException;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.ModifyException;
import com.day.myblog.exception.RemoveException;
import com.day.myblog.utils.PagingVO;

public interface BoardDAO {
	
	String insert(Board board) throws AddException;
	
	List<Board> selectAll(PagingVO vo) throws FindException;
	
	int CountBoard();
	
	Board selectById(int id) throws FindException;
	
	String deleteById(int id) throws RemoveException;
	
	void update(Board board) throws ModifyException;

}
