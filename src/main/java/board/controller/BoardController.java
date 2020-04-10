package board.controller;

import java.util.List;    

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.DtoDaoService.BoardDto;
import board.DtoDaoService.BoardService;

@Controller
@RequestMapping("BoardList.do")
public class BoardController{
	
	@Autowired
	BoardService boardService;
	
	//리스트 전부 보여주기!!!!!!!!!!!!
	@RequestMapping
	public String showList(Model aModel) {
		List<BoardDto> list = boardService.listAll();
		aModel.addAttribute("list",list);
		//request.setAttribute와 똑같은 표현
		return "board/list";
	}
	
/*	
	@Controller
	@RequestMapping("/board/*")
	public class BoardController{
		
		@Autowired
		BoardService boardService;
		
		//리스트 전부 보여주기!!!!!!!!!!!!
		@RequestMapping("list.do")
		public String showList(Model aModel) {
			List<BoardDto> list = boardService.listAll();
			aModel.addAttribute("list",list);
			//request.setAttribute와 똑같은 표현
			return "board/list";
		}
		
		//게시글을 작성 화면
		@GetMapping("write.do")
		public String write() {
			return "board/write";
		}
		//게시글을 작성 넘어가는 화면
		@PostMapping("insert.do")
		public String insert(@ModelAttribute("BoardDto")BoardDto bdto) {
			boardService.insert(bdto);
			return "board/insert";
		}
		
		//게시글 상세내용 조회
		@RequestMapping(value = "view.do", method = RequestMethod.GET)
		public ModelAndView view(@RequestParam int code, HttpSession session) {
		
		//조회수 증가
		boardService.increaseViewcnt(code,session);
		
		//view 상세내역 조회
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("BoardDto",boardService.read(code));
		//여기는 뷰에서 보일 이름을 설정하는 곳
		return mav;
		}
		
		//게시글 수정하기
		@PostMapping("update.do")
		public String update(@ModelAttribute("BoardDto")BoardDto bdto) {
			boardService.update(bdto);
			return "redirect:list.do";
		}
		
		//게시글 삭제하기
		@PostMapping("delete.do")
		public String delete(@RequestParam int code) {
			boardService.delete(code);
			return "redirect:list.do";
		}


	}
*/

}
