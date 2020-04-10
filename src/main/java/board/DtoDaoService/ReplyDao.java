package board.DtoDaoService;

import java.util.List;

public interface ReplyDao {
	
	//목록보여주기
	public List<ReplyDto> list(int code);
	//댓글 입력
	public void create(ReplyDto rdto);
	//댓글 수정
	public void update(ReplyDto rdto);
	//댓글삭제
	public void delete(int rno);


}
