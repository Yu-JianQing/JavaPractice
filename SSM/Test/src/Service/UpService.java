package Service;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

public interface UpService {
	public void readFile(File file,HttpServletResponse response);
}
