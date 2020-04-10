package regist;

import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class RegistDao extends SqlSessionDaoSupport
{
    public int insert(MemberInfo m) {
        return getSqlSession().insert("regist.s_insert", m);
    }
    
    public List<String> getEmail() {
        return getSqlSession().selectList("regist.s_email");
    }
    
    public int photoRegist(PhotoDto dto) {		  
    	return getSqlSession().insert("regist.photoInsert",dto);
    }
    
}
