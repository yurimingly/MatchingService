package board.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import board.DtoDaoService.ReplyDto;
import board.DtoDaoService.ReplyService;


@RestController
@RequestMapping("replylist.do")
public class ReplyController {

		@Autowired
		ReplyService replyService;
		
		//restcontroller방식
	/* @ResponseBody */
        @RequestMapping
		public List<ReplyDto> listJson(@RequestParam int code){
			List<ReplyDto> list = replyService.list(code);
			return list;
		}
	

/*
		//controller방식	
		//리스트 전부 보여주기!!!!!!!!!!!!
		@RequestMapping
		@ResponseBody
		public String list(@RequestParam int code){
			
			List<ReplyDto> list = replyService.list(code);
			//mav.addObject("list", list);
			Gson jso= new Gson();
			String data = jso.toJson(list);

			return data;
		}
*/
	
		
}
