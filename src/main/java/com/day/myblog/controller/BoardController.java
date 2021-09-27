package com.day.myblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.day.myblog.configuration.auth.PrincipalDetail;
import com.day.myblog.dto.Board;
import com.day.myblog.exception.FindException;
import com.day.myblog.exception.ModifyException;
import com.day.myblog.service.BoardService;
import com.day.myblog.service.ReplyService;
import com.day.myblog.service.UserService;
import com.day.myblog.utils.PagingVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReplyService replyService;
	
	@GetMapping({"","/"})
	public String index(Model model, PagingVO vo, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) throws FindException {
		int total = boardService.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "6";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "6";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", vo);
		model.addAttribute("boards", boardService.list(vo));
		return "index";
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) throws FindException, ModifyException {
		boardService.updateCnt(id);
		model.addAttribute("user", userService.selectById(boardService.seeDetail(id).getUserid()));
		model.addAttribute("board", boardService.seeDetail(id));
		model.addAttribute("replys", boardService.selectAll(id));
		model.addAttribute("reply", replyService.selectById(id));
		return "board/detail";
	}
	
	@GetMapping("/board/{id}/updateForm")
	public String updateFrom(@PathVariable int id, Model model) throws FindException {
		model.addAttribute("board", boardService.seeDetail(id));
		return "board/updateForm";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
	@GetMapping("/board/calendar")
	public String calendar() {
		return "board/calendar";
	}

}
