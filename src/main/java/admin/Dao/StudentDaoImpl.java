package admin.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

@Component
public class StudentDaoImpl  implements StudentDao
{
	@Autowired
	SqlSession sqlSession;
	
    //학생 리스트 겟
	@Override
	public List<StudentDto> StudentList()
	{
		return sqlSession.selectList("admin.studentList");
	}
	
	@Override
	public void Delete(int s_num)
	{
		sqlSession.delete("admin.DeleteStudent", s_num);
	}
}
