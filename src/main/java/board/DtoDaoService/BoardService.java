package board.DtoDaoService;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import login.LoginCommand;

public interface BoardService {
	
	//게시글 목록 LIST
	//public List<BoardDto> listAll();
	public List<BoardDto> listAll(String searchOption, String keyword);
	
	//게시글 레코드 갯수 메서드 추가
	public int countArticle(String searchOption, String keyword);
	
	//게시글 작성 C
	public void insert(BoardDto bdto);
	
	//게시글 상세보기 R
	public BoardDto read(int code);
	
	//게시글 비밀번호 체크
	public BoardDto passwordcheck(HashMap<Object, Object> m);
	
	//게시글 수정하기 U
	public void update(BoardDto bdto);
	
	//게시글 삭제하기 D
	public void delete(int code);
	
	//게시글 조회수 올리기
	public void increaseViewcnt(int code, HttpSession session);

	
	//게시글 확인
	public List<LoginCommand> boardemailcheck();
	
	//게시물 총 갯수
	public int listCount();
	//페이징
	public List<BoardDto> listLimit(PagingData pagingData);

}
