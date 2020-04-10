package board.DtoDaoService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDaoImpl implements ReplyDao{
	@Autowired
	SqlSession sqlSession;

	//댓글목록
	@Override
	public List<ReplyDto> list(int code) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("reply.listReply",code);
	}

	@Override
	public void create(ReplyDto rdto) {
		sqlSession.insert("reply.insertReply",rdto);
	}

	//댓글수정
	@Override
	public void update(ReplyDto rdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
		
	}
	
	

}
