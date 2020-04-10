package board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.DtoDaoService.BoardDto;
import board.DtoDaoService.BoardService;

@Component
@RequestMapping("updatepath.do")
public class UpdatePath {

	@Autowired
	BoardService boardservice;
	
	@RequestMapping
	public ModelAndView uD(@RequestParam int code, HttpSession session){
		//이 길은 수정으로 가는 길
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/update");
		mav.addObject("BoardDto",boardservice.read(code));
		/*여기는 뷰에서 보일 이름을 설정하는 곳*/
		return mav;
	}

}
