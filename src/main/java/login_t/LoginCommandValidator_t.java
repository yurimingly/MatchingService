package login_t;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

@Component
public class LoginCommandValidator_t implements Validator{

	@Autowired
	private LoginService_t serv;
	public void setServ(LoginService_t serv) { this.serv = serv; }

	@Override
	public boolean supports(Class<?> clazz) { return LoginCommand_t.class.isAssignableFrom(clazz); }

	@Override
	public void validate(Object target, Errors errors) {
		serv.checkEmail(target, errors);
	}

}
