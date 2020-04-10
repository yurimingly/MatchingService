package board.DtoDaoService;

import java.sql.Timestamp; 
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.LoginCommand;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDao boardDao;
	//dao에게 모든 권한을 위임해주려고 한다
	
	//리스트 전부 보여주기!!!!!!!!!!!!! LIST
	@Override
	public List<BoardDto> listAll() {
		return boardDao.listAll();
	}
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	//board email과 확인하려고
	@Override
	public List<LoginCommand> boardemailcheck() {
		return boardDao.boardemailcheck();
	}

	//게시글 글쓰기 C
	@Override
	public void insert(BoardDto bdto) {
		int code=bdto.getCode();
		
//		int originNo=bdto.getOriginNo();
//		int groupOrd=bdto.getGroupOrd();
//		int groupLayer=bdto.getGroupLayer();
		
		String title=bdto.getTitle();
		String content=bdto.getContent();
		String writer=bdto.getWriter();
		String email=bdto.getEmail();
		Timestamp reg_date=bdto.getReg_datetime();
		
		//보안문제로 인해서 태그문자를 처리
		title = title.replace("<","&lt;");
		title = title.replace(">","&gt;");
		writer = writer.replace("<","&lt;");
		writer = writer.replace(">","&gt;");
		//공백문자를 처리
		title = title.replace(" ", "&nbsp;&nbsp;");
		writer = writer.replace(" ", "&nbsp;&nbsp;");
		//줄바꿈 문자처리
		content=content.replace("\n","<br>");
		
		bdto.setCode(code);
		bdto.setTitle(title);
		bdto.setContent(content);
		bdto.setWriter(writer);
		bdto.setReg_datetime(reg_date);
		
//		//계층형 게시판을 위한 추가
//		bdto.setOriginNo(originNo);
//		bdto.setGroupOrd(groupOrd);
//		bdto.setGroupLayer(groupLayer);
		
		boardDao.insert(bdto);
	}


    //게시글 상세보기 R
	@Override
	public BoardDto read(int code) {
		return boardDao.read(code);
	}
	
	//게시글 수정하기 U
	@Override
	public void update(BoardDto bdto) {
		boardDao.update(bdto);
		
	}

	//게시글 삭제하기 D
	@Override
	public void delete(int code) {
		// TODO Auto-generated method stub
		boardDao.delete(code);		
	}

	//게시글 조회수 올리기
	@Override
	public void increaseViewcnt(int code, HttpSession session) {
		long update_time=0;
		long current_time = System.currentTimeMillis();

		if(session.getAttribute("update_time"+code)!=null) {
			update_time=(long)session.getAttribute("update_time"+code);
		}
		
		if(current_time - update_time>5*1000) {
			boardDao.increaseViewcnt(code);
			session.setAttribute("update_time"+code, current_time);
		}
		
	}

	
	//게시글 답글작성C
	@Override
	public void insertLayer(BoardDto bdto) {
		// TODO Auto-generated method stub
		int code=bdto.getCode();
		
//		int originNo=bdto.getOriginNo();
//		int groupOrd=bdto.getGroupOrd();
//		int groupLayer=bdto.getGroupLayer();
		
		String title=bdto.getTitle();
		String content=bdto.getContent();
		String writer=bdto.getWriter();
		Timestamp reg_date=bdto.getReg_datetime();
		
		
		bdto.setCode(code);
		bdto.setTitle(title);
		bdto.setContent(content);
		bdto.setWriter(writer);
		bdto.setReg_datetime(reg_date);

	
//		//계층형 게시판을 위한 추가
//		bdto.setOriginNo(originNo);
//		bdto.setGroupOrd(groupOrd);
//		bdto.setGroupLayer(groupLayer);
//		
		
		boardDao.insertLayer(bdto);

	}
	

}
