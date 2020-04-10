package login;

import org.springframework.beans.factory.annotation.Autowired
;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import login.LoginCommand;

@Component
public class LoginCommandValidator implements Validator{

	@Autowired
	private LoginService serv;
	public void setServ(LoginService serv) { this.serv = serv; }

	@Override
	public boolean supports(Class<?> clazz) { return LoginCommand.class.isAssignableFrom(clazz); }

	@Override
	public void validate(Object target, Errors errors) {
		serv.checkEmail(target, errors);
	}

}
