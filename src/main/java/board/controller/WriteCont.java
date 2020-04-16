package board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.DtoDaoService.BoardService;
import login.LoginCommand;

@Controller
@RequestMapping(value = "write.do", method = RequestMethod.GET)
public class WriteCont {

	@Autowired
	BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping
	public String write(Model wModel, HttpSession session) {
		List<LoginCommand> check = boardService.boardemailcheck();
//		System.out.println(check);
		wModel.addAttribute("check", check);
		return "board/write";
	}
}
