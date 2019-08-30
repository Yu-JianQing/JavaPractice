package ch9x6;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MultiFiles {
	private List<String> des;
	private List<MultipartFile> myFile;
	
	public List<String> getDes() {
		return des;
	}
	public void setDes(List<String> des) {
		this.des = des;
	}
	public List<MultipartFile> getMyFile() {
		return myFile;
	}
	public void setMyFile(List<MultipartFile> myFile) {
		this.myFile = myFile;
	}
	
}
