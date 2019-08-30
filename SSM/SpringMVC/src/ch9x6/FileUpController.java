package ch9x6;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch9x6/")
public class FileUpController {
	
	@RequestMapping("/onefile")
	public String onefile(@ModelAttribute FileBean fileBean,HttpServletRequest request){
		String path=request.getServletContext().getRealPath("uploadfiles");
		
		String fileName=fileBean.getmyFile().getOriginalFilename();
		
		File file=new File(path, fileName);
		
		if(!file.exists())
			file.mkdirs();
		
		try {
			fileBean.getmyFile().transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "showone";
	}
	
}
