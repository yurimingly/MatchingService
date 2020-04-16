package admin.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import admin.Dao.*;

@Component
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	@Override
	public List<TeacherDto> TeacherList() {
		return teacherDao.TeacherList();
	}

	@Override
	public void Delete(int t_num) 
	{
		teacherDao.Delete(t_num);
	}

}
