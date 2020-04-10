package login_t;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import regist_t.MemberInfo_t;

@Controller
@RequestMapping("LoginTeacher.do")
public class LoginController_t {
	
	@Autowired
	private LoginService_t serv;
	public void setServ(LoginService_t serv) {
		this.serv = serv;
	}

	@Autowired
	private LoginCommandValidator_t vali;
	public void setVali(LoginCommandValidator_t vali) { this.vali = vali; }

	@ModelAttribute("login")
	public LoginCommand_t formBacking() {return new LoginCommand_t();}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {return "login_t/loginForm_t";}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(@ModelAttribute("login") LoginCommand_t loginCommand,BindingResult result, HttpSession session){
		vali.validate(loginCommand,result);
		if(result.hasErrors()) {
			return "login_t/loginForm_t";
		}
		String t_email=loginCommand.getT_email();
		MemberInfo_t loginData=serv.getMemberInfo(t_email);
		session.setAttribute("loginData",loginData);
		
		session.setAttribute("loginData",loginData);
		return "login_t/loginSuccess_t";
	}
}
