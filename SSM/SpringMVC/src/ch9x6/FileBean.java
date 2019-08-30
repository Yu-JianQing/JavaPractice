package ch9x6;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileBean {
	private MultipartFile myFile;
	private String des;
	
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public MultipartFile getmyFile() {
		return myFile;
	}
	public void setmyFile(MultipartFile myFile) {
		this.myFile = myFile;
	}
}
