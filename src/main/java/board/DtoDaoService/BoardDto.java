package board.DtoDaoService;

import java.sql.Timestamp;

public class BoardDto{
	
	private int code;
	private String title;
	private String content;
	private String writer;
	private String email;
	private Timestamp reg_datetime;
	private int viewcnt;
	//게시글 댓글의 수 추가
	private int recnt;
	private String password;
	
	public BoardDto() {};
	
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	
	public Timestamp getReg_datetime() {
		return reg_datetime;
	}
	public void setReg_datetime(Timestamp reg_datetime) {
		this.reg_datetime = reg_datetime;
	}
	
	public int getRecnt() {
		return recnt;
	}
	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public BoardDto(int code, String title, String content, String writer, String email, Timestamp reg_datetime,
			int viewcnt, int recnt, String password) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.email = email;
		this.reg_datetime = reg_datetime;
		this.viewcnt = viewcnt;
		this.recnt = recnt;
		this.password = password;
	}



	@Override
	public String toString() {
		return "BoardDto [code=" + code + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", email=" + email + ", reg_datetime=" + reg_datetime + ", viewcnt=" + viewcnt + ", recnt=" + recnt
				+ ", password=" + password + "]";
	}
	
	
	
	

}
