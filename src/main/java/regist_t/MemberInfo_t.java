package regist_t;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo_t {
	private String name;
	private String password;
	private String reCheck;
	private String t_email;
	private String t_phone;
	private MultipartFile photo;
	private String strphoto;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getReCheck() {
		return reCheck;
	}
	public void setReCheck(String reCheck) {
		this.reCheck = reCheck;
	}
	public String getT_email() {
		return t_email;
	}
	public void setT_email(String t_email) {
		this.t_email = t_email;
	}
	public String getT_phone() {
		return t_phone;
	}
	public void setT_phone(String t_phone) {
		this.t_phone = t_phone;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getStrphoto() {
		return strphoto;
	}
	public void setStrphoto(String strphoto) {
		this.strphoto = strphoto;
	}

}
