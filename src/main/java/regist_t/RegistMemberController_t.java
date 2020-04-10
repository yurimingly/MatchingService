package regist_t;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/RegistTeacher.do")
public class RegistMemberController_t
{
    @Autowired
    private RegistService_t serv;
    @Autowired
    private MemberInfoValidator_t vali;
    private String formViewName = "teacher/t_regist/memberForm_t";;
    
    public void setServ(RegistService_t serv) {
        this.serv = serv;
    }
    
    public void setVali(MemberInfoValidator_t vali) {
        this.vali = vali;
    }
    
    @ModelAttribute("memberInfo")
    protected Object formBackingObject() throws Exception {
        return new MemberInfo_t();
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String form(Model model) {
        return formViewName;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("memberInfo") MemberInfo_t memberInfo, BindingResult result, Model model) {
        vali.validate(memberInfo, result);
        if (result.hasErrors()) {
            return formViewName;
        }
        serv.insert(memberInfo);
        return "teacher/t_regist/success";
    }
}