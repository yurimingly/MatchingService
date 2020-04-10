package board.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import board.DtoDaoService.BoardService;

@Component
@RequestMapping(value="delete.do", method = RequestMethod.GET)
public class DeleteCont {
	@Autowired
	BoardService boardService;
	
	//게시글 삭제하기
		@PostMapping
		public String delete(@RequestParam int code) {
			boardService.delete(code);
			return "redirect:BoardList.do";
		}
}
