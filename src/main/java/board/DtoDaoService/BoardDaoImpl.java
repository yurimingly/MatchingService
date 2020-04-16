package board.DtoDaoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import login.LoginCommand;

import org.apache.ibatis.session.SqlSession;

@Component //이렇게 해야 autowired에 의한 연결에 적용된다.
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	SqlSession SqlSession;

	//게시글 목록
	@Override
	public List<BoardDto> listAll(String searchOption, String keyword) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		return SqlSession.selectList("board.listAll",map);
	}
	
	/*
	//게시글 목록
	@Override
	public List<BoardDto> listAll() {
		return SqlSession.selectList("board.listAll");
	}*/

	
	//게시글 레코드 갯수
	@Override
	public int countArticle(String searchOption, String keyword) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return SqlSession.selectOne("board.countArticle",map);
	}
	

	//게시글 작성 C
	@Override
	public void insert(BoardDto bdto) {
		/* BoardM */
		SqlSession.insert("board.insert",bdto);
	}


	//게시글 상세보기 R
	@Override
	public BoardDto read(int code) {
		// TODO Auto-generated method stub
		return SqlSession.selectOne("board.view",code);
	}
	

	@Override
	public BoardDto passwordcheck(HashMap<Object, Object> m) {
		return  SqlSession.selectOne("board.passwordcheck",m);
	}

	//게시글 수정하기 U
	@Override
	public void update(BoardDto bdto) {
		SqlSession.update("board.updateBoard",bdto);	
	}


	//게시글 삭제하기 D
	@Override
	public void delete(int code) {
		SqlSession.delete("board.deleteBoard", code);
	}

	//게시글 조회수올리기 
	@Override
	public void increaseViewcnt(int code) {
		SqlSession.update("board.increaseViewcnt", code);	
	}
	
	//게시글 쓸 때 비회원인지 회원인지 확인할때 
	@Override
	public List<LoginCommand> boardemailcheck() {
		return SqlSession.selectList("board.emailcheck");
	}

	@Override
	public int listCount() {
		return SqlSession.selectOne("board.listcount");
	}

	@Override
	public List<BoardDto> listLimit(PagingData pagingData) {
		return SqlSession.selectList("board.limitcount",pagingData);
	}
	
	
	


}
