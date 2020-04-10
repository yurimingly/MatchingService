package regist;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {
	private String name;
	private String password;
	private String reCheck;
	private String s_email;
	private String s_phone;
	private String s_tag;
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
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public String getS_tag() {
		return s_tag;
	}
	public void setS_tag(String s_tag) {
		this.s_tag = s_tag;
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
