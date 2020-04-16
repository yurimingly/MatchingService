package board.controller;

import javax.servlet.http.HttpSession;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.DtoDaoService.ReplyDto;
import board.DtoDaoService.ReplyService;

@RestController
@RequestMapping(value="replyinsert.do", method = RequestMethod.POST)
public class ReplyInsertCont {

	@Autowired
	ReplyService replyService;
	
	@RequestMapping
	public void insert(@ModelAttribute("ReplyDto") ReplyDto rdto, HttpSession session) {
		System.out.println(rdto);
	//String s_email= (String) session.getAttribute("s_email");
	//rdto.setReplyer(s_email);
	replyService.create(rdto);
    }
}