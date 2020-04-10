package regist;

import regist.MemberInfo;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

@Component
public class MemberInfoValidator implements Validator
{
    @Autowired
    private RegistService serv;
    
    public void setServ(RegistService serv) {
        this.serv = serv;
    }
    
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "s_phone", "required");
        
        errors = serv.checkServ(target, errors);
        
        
    }
    
    public boolean supports(Class<?> clazz) {
        return MemberInfo.class.isAssignableFrom(clazz);
    }
}
