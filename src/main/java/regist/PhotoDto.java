package regist;

import org.springframework.stereotype.Component;

@Component
public class PhotoDto {
	private String photo;
	private String photo_name;
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

}
