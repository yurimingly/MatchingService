package admin.Dao;

import java.util.List;

public interface TeacherDao
{
	public List<TeacherDto> TeacherList();
	
	public void Delete(int t_num);
}
