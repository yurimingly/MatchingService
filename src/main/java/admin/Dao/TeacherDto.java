package admin.Dao;

public class TeacherDto 
{
	private int t_num;
	private String name;
	private String t_email;
	private String t_phone;
	
	public TeacherDto() {}
	
	public TeacherDto(int t_num, String name, String t_email, String t_phone)
	{
		super();
		this.t_num = t_num;
		this.name = name;
		this.t_email = t_email;
		this.t_phone = t_phone;
	}
	
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}
