package regist_t;

import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import regist.PhotoDto;

public class RegistDao_t extends SqlSessionDaoSupport
{
    public int insert(MemberInfo_t m) {
        return getSqlSession().insert("regist.t_insert", m);
    }
    
    public List<String> getEmail() {
        return getSqlSession().selectList("regist.t_email");
    }
    public int photoRegist(PhotoDto dto) {		  
    	return getSqlSession().insert("regist.photoInsert",dto);
    }
}
