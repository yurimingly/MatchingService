package admin.Dao;

import java.util.List;

public interface StudentDao
{
	//리스트 보여주기
	public List<StudentDto> StudentList();
	
	public void Delete(int s_num);
}
