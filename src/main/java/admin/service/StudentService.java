package admin.service;

import java.util.List;
import admin.Dao.StudentDto;

public interface StudentService 
{
	public List<StudentDto> StudentList();
	
	public void Delete(int s_num);
}
