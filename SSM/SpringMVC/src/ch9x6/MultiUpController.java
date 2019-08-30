package ch9x6;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ch9x6/")
public class MultiUpController {
	
	@RequestMapping("/multifiles")
	public String multifiles(@ModelAttribute MultiFiles multiFiles,HttpServletRequest request){
		String path=request.getServletContext().getRealPath("uploadfiles");
		
		File file=new File(path);
		if(!file.exists())
			file.mkdirs();
		
		List<MultipartFile> multipartFiles=multiFiles.getMyFile();
		for(MultipartFile mf:multipartFiles){
			String fileName=mf.getOriginalFilename();System.out.println(mf.getName());
			
			File realFile=new File(path,fileName);
			try {
				mf.transferTo(realFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return "showfiles";
	}
}
