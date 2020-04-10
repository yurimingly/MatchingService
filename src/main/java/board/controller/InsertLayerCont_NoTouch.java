/*package board.controller;
package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.BoardDto;
import spring.service.BoardService;

@Controller
@RequestMapping(value="insertLayer.do",method=RequestMethod.POST)
public class InsertLayerCont {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping
	public String insertLayer(@ModelAttribute("BoardDto")BoardDto bdto) {
		boardService.insertLayer(bdto);
		return "board/insert";
	}

}
*/