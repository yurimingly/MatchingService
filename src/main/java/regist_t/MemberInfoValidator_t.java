package regist_t;

import regist.MemberInfo;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

@Component
public class MemberInfoValidator_t implements Validator
{
    @Autowired
    private RegistService_t serv;
    
    public void setServ(RegistService_t serv) {
        this.serv = serv;
    }
    
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "t_phone", "required");
        errors = serv.checkEmail(target, errors);
    }
    
    public boolean supports(Class<?> clazz) {
        return MemberInfo.class.isAssignableFrom(clazz);
    }
}
