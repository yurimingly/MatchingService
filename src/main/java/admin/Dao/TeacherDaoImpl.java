package admin.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherDaoImpl implements TeacherDao {

	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public List<TeacherDto> TeacherList() {
		return sqlSession.selectList("admin.teacherList");
	}

	@Override
	public void Delete(int t_num) {
		sqlSession.delete("admin.DeleteTeacher", t_num);
	}

}
