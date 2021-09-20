package com.day.myblog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.day.myblog.configuration.auth.PrincipalDetail;
import com.day.myblog.dto.Board;
import com.day.myblog.dto.ResponseDto;
import com.day.myblog.dto.User;
import com.day.myblog.exception.AddException;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.ModifyException;
import com.day.myblog.exception.RemoveException;
import com.day.myblog.service.BoardService;
import com.day.myblog.service.UserService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) throws AddException {
		try {
			int result = boardService.write(board, principal.getUser());
			if(result == 1) {
				return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
			}else {
				return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), result);
			}
		} catch (AddException e) {
			e.printStackTrace();
			throw new AddException("글쓰기 실패!!");
		}
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id) throws RemoveException {
		int result = boardService.delete(id);
		if(result == 1) {
			return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
		}else {
			return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), result);
		}
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board) throws FindException, ModifyException {
		int result = boardService.update(id, board);
		if(result == 1) {
			return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
		}else {
			return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), result);
		}
	}
	
}
