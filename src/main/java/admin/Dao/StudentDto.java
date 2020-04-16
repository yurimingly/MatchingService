package admin.Dao;

public class StudentDto
{
	private int s_num;
	private String name;
	private String password;
	private String s_email;
	private String s_phone;
	private String s_tag;
	
	public int getS_num() {
		return s_num;
	}
	public void setS_num(int s_num) {
		this.s_num = s_num;
	}
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
	
	public StudentDto() {}
	
	public StudentDto(int s_num, String name, String password, String s_email, String s_phone, String s_tag)
	{
		super();
		this.s_num = s_num;
		this.name = name;
		this.password = password;
		this.s_email = s_email;
		this.s_phone = s_phone;
		this.s_tag = s_tag;
				
	}
}
