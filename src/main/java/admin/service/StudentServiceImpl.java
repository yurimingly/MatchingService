package admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import admin.Dao.*;
@Component
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<StudentDto> StudentList()
	{
		return studentDao.StudentList();
	}
	
	public void Delete(int s_num)
	{
		studentDao.Delete(s_num);
	}
}
