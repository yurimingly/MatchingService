package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.DtoDaoService.BoardDto;
import board.DtoDaoService.BoardService;

@Component
@RequestMapping(value="update.do", method=RequestMethod.POST)
public class UpdateCont {
	@Autowired
	BoardService boardService;
	
	//게시글 수정하기
		@PostMapping
		public String update(@ModelAttribute("BoardDto")BoardDto bdto) {
			boardService.update(bdto);
			return "redirect:BoardList.do";
		}
		
}
