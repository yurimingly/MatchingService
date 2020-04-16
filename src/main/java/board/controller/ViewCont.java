package board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.DtoDaoService.BoardService;
import login.LoginCommand;

@Controller
@RequestMapping(value = "view.do", method = RequestMethod.GET)
public class ViewCont {
		@Autowired
		BoardService boardService;
		
		
	    //게시글 상세내용 조회
		@RequestMapping
		public ModelAndView view(@RequestParam int code,HttpSession session) {
		
		//조회수 증가
		boardService.increaseViewcnt(code,session);
		
		//view 상세내역 조회
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("BoardDto",boardService.read(code));

		/*여기는 뷰에서 보일 이름을 설정하는 곳*/
		return mav;
		}
}
