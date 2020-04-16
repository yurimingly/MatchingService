package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import board.DtoDaoService.PagingData;

@Controller
@RequestMapping("BoardList.do")
public class BoardController{
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping
	public ModelAndView list(@RequestParam(defaultValue="all") String searchOption,
							 @RequestParam(defaultValue="", required=false) String keyword,
							 @RequestParam(defaultValue = "1") int curPage){
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		//리스트
		List<BoardDto> list= boardService.listAll(searchOption, keyword);
		map.put("list", list); //list
		
		//레코드 갯수
		int count = boardService.countArticle(searchOption, keyword);
		map.put("count", count); //레코드갯수
		
		//검색옵션
		map.put("searchOption", searchOption);
		
		//뭘로 검색할지
		map.put("keyword", keyword);
		
		//뷰만들어 놓고
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("map", map);//맵에 저장된 데이터를 mv에 저장
		mv.setViewName("board/list");//뷰를 list.jsp로 설정해서 넘김
		
		//리스트 개수
		int listCnt = boardService.listCount();
		//현재페이지
		PagingData pagingData = new PagingData(listCnt, curPage);
		//몇개씩만 가져오겠다
		List<BoardDto> list2 = boardService.listLimit(pagingData);
		
		//페이징
		mv.addObject("list2", list2);
		mv.addObject("listCnt", listCnt);
		mv.addObject("pagingData", pagingData);
		
		return mv;
	}
	

}
