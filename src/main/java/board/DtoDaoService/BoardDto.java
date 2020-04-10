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

	/*
	 * //계층형 게시판을 위한 추가 private int originNo; private int groupOrd; private int
	 * groupLayer;
	 * 
	 */	
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
	/*
	 * public int getOriginNo() { return originNo; } public void setOriginNo(int
	 * originNo) { this.originNo = originNo; } public int getGroupOrd() { return
	 * groupOrd; } public void setGroupOrd(int groupOrd) { this.groupOrd = groupOrd;
	 * } public int getGroupLayer() { return groupLayer; } public void
	 * setGroupLayer(int groupLayer) { this.groupLayer = groupLayer; }
	 */
	public BoardDto() {}
	
	public BoardDto(int code, String title, String content, String writer, Timestamp reg_datetime, int viewcnt) {
		super();
		this.code = code;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.reg_datetime = reg_datetime;
		this.viewcnt = viewcnt;
	}
	
	@Override
	public String toString() {
		return "BoardDto [code=" + code + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", reg_datetime=" + reg_datetime + "]";
	}

}
