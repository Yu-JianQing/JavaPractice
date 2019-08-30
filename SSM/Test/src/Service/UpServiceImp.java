package Service;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class UpServiceImp implements UpService{

	@Override
	public void readFile(File file,HttpServletResponse response) {
		try {
			FileInputStream in=new FileInputStream(file);
			ServletOutputStream out=response.getOutputStream();
			
			byte b[]=new byte[10000];int n;
			while((n=in.read(b))!=-1){
				out.write(b, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
