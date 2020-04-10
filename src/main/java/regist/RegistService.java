package regist;

import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistService{
    @Autowired
    private RegistDao dao;
    private List<String> e;
    
    @Autowired
    private ReportService servR;
	public void setServR(ReportService servR) {this.servR = servR;}

	public void setDao(RegistDao dao) {
        this.dao = dao;
    }
    
    public int insert(MemberInfo m) {
    	MultipartFile photo=m.getPhoto();
    	PhotoDto dto = servR.upload(photo);
    	if(dto.getPhoto()!=null) {
	    	dao.photoRegist(dto);
	    	m.setStrphoto(dto.getPhoto());
    	}
        return dao.insert(m);
    }
    
    public List<String> getEmail() {
        return e = dao.getEmail();
    }
    
    public Errors checkServ(Object target, Errors errors) {
        MemberInfo memberInfo = (MemberInfo)target;
        
        e = getEmail();
        String s_email = memberInfo.getS_email();
        if (s_email.equals("")) {
            errors.rejectValue("s_email", "required");
        }
        else {
            int x = 0;
            for (int i = 0; i < e.size(); ++i) {
                if (e.get(i).equals(s_email)) {
                    x = 1;
                }
            }
            if (x == 1) {
                errors.rejectValue("s_email", "notUnique");
            }
        }
        
        checkPasswd(target, errors);
      
        return errors;
    }
    private void checkPasswd (Object target, Errors errors) {
    	MemberInfo memberInfo = (MemberInfo)target;
    	String password=memberInfo.getPassword();
        String reCheck=memberInfo.getReCheck();
        
        if(password.equals("") || reCheck.equals("")) {
        	errors.rejectValue("password", "required"); 
        	errors.rejectValue("reCheck", "required"); 
        }
        else if(!reCheck.equals(password)) { 
        	errors.rejectValue("password", "required"); 
        	errors.rejectValue("reCheck", "reCheckErr"); 
        }else if(errors.getErrorCount()>0) {
        	errors.rejectValue("password", "required"); 
        	errors.rejectValue("reCheck", "required"); 
        }
    }
}