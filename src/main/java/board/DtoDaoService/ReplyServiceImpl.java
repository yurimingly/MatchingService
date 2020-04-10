package board.DtoDaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	ReplyDao replyDao;

	@Override
	public List<ReplyDto> list(int code) {
		// TODO Auto-generated method stub
		return replyDao.list(code);
	}

	@Override
	public void create(ReplyDto rdto) {
		// TODO Auto-generated method stub
		replyDao.create(rdto);
	}

	@Override
	public void update(ReplyDto rdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int rno) {
		// TODO Auto-generated method stub
		
	}
	
}
