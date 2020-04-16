package board.DtoDaoService;

import java.util.HashMap;
import java.util.List;

import login.LoginCommand;

public interface BoardDao {
	
	//목록보여주기
	public List<BoardDto> listAll(String searchOption, String keyword);
	//public List<BoardDto> listAll();
	
	//게시글 레코드 갯수 메서드
	public int countArticle(String searchOption, String keyword);

	//게시글 작성하기 C
	public void insert(BoardDto bdto);

	//게시글 상세보기 R
	public BoardDto read(int code);
	
	//게시글 비밀번호 확인
	public BoardDto passwordcheck(HashMap<Object, Object> m);

	//게시글 수정하기 U
	public void update(BoardDto bdto);
	
	//게시글 삭제하기 D
	public void delete(int code);
	
	//게시글 조회수 올리기
	public void increaseViewcnt(int code);
	
	//write할때 비회원인지 회원인지 아는법
	public List<LoginCommand> boardemailcheck();
	
	//게시글 전체 카운트
	public int listCount();
	public List<BoardDto> listLimit(PagingData pagingData);


}
