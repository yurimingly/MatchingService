package board.controller;

import javax.servlet.http.HttpSession; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import board.DtoDaoService.ReplyDto;
import board.DtoDaoService.ReplyService;

@RestController
@RequestMapping("replyinsert.do")
public class ReplyInsertCont {

	@Autowired
	ReplyService replyService;
	
	@RequestMapping
	public void insert(@ModelAttribute("ReplyDto") ReplyDto rdto, HttpSession session) {
	String s_email= (String) session.getAttribute("s_email");
	rdto.setReplyer(s_email);
	replyService.create(rdto);
    }
}