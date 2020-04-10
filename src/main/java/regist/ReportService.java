package regist;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReportService {
	
	@Autowired
	private PhotoDto dto;
	public void setDto(PhotoDto dto) { this.dto = dto; }

	public PhotoDto upload(MultipartFile report) {
		String name=report.getOriginalFilename();
		int index=name.lastIndexOf(".");
		String n_name;
		File n_file;
		
		if(index!=-1) { String ext=name.substring(index); 
			n_name=System.currentTimeMillis()+"_"+new Random().nextInt(50)+"."+ext;
			n_file=new File("d://syshinsmile//back-end//testImage//"+n_name);
			try { report.transferTo(n_file);}
			catch (IllegalStateException e) {e.printStackTrace();}
			catch(IOException e) {e.printStackTrace();}
			
			dto.setPhoto(n_name);
			dto.setPhoto_name(name);	
		}
		return dto;	 
	}
}
