package board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import board.DtoDaoService.BoardDto;
import board.DtoDaoService.BoardService;
import login.LoginCommand;

@Controller
@RequestMapping
public class passwordcheck {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="passwordcheck.do", method=RequestMethod.GET)
	public ModelAndView mv(@RequestParam int code) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/passwordcheck");
		mv.addObject("BoardDto", boardService.read(code));
		return mv;
	}

	
	@ResponseBody
	@RequestMapping(value="passwordcheck.do", method=RequestMethod.POST)
	public String passwordcheck2(@RequestParam int code,
								 String password,
								 HttpSession session) {
		/* System.out.println(password); */
		//gson객체생성
		Gson gson = new Gson();
		JsonObject json = new JsonObject();
		
		/*
		 * String email = (String) session.getAttribute("s_email");
		 */
		HashMap<Object,Object> m = new HashMap<Object, Object>();
		m.put("code", code);
		m.put("password", password);
		//m.put(key,value)
				
		int num=0;
		BoardDto passwordcheck = boardService.passwordcheck(m);
		System.out.println(passwordcheck);
		
		//code와 password가 같아야 passwordcheck가 같다. 일치하면
		if(passwordcheck==null) {
			num=0;
		}else {
			num=1;
		}
		
		json.addProperty("num", num);
		return gson.toJson(json);
	}

	
}
