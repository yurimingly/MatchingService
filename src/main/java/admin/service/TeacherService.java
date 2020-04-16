package admin.service;

import java.util.List;

import admin.Dao.TeacherDto;

public interface TeacherService 
{
	public List<TeacherDto> TeacherList();
	
	public void Delete(int t_num);
}
