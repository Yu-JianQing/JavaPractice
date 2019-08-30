package Test;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UpFile {
	private List<MultipartFile> myfile;

	public List<MultipartFile> getMyfile() {
		return myfile;
	}

	public void setMyfile(List<MultipartFile> myfile) {
		this.myfile = myfile;
	}

	@Override
	public String toString() {
		return "UpFile [myfile=" + myfile + "]";
	}
	
}
