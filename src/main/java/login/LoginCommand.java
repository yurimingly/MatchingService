package login;

public class LoginCommand {
	private String s_email;
	private String password;
	
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginCommand [s_email=" + s_email + ", password=" + password + "]";
	}
	

}
