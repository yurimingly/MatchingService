package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.DtoDaoService.BoardDto;
import board.DtoDaoService.BoardService;

@Controller
@RequestMapping("insert.do")
public class InsertCont {
	
	@Autowired
	BoardService boardService;
	
		
	//게시글을 작성 넘어가는 화면
	@RequestMapping
	public String insert(@ModelAttribute("BoardDto")BoardDto bdto) {
		if(bdto.getPassword().equals("")) {
			bdto.setPassword(null);
		}		
		boardService.insert(bdto);
		

		return "board/insert";
	}
}
