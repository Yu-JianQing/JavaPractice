package MVC;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import Service.UpService;
import Test.UpFile;

@Controller
@RequestMapping("/shopping/")
public class UpController {
	@Autowired
	UpService upService;

	@RequestMapping("/up")
	public String up(@ModelAttribute UpFile upFile,HttpServletRequest request){
		List<MultipartFile> mulFiles=upFile.getMyfile();
		
		String path=request.getServletContext().getRealPath("uploadfiles");
		File dir=new File(path);
		if(!dir.exists())
			dir.mkdirs();
		for(MultipartFile mfile:mulFiles){
			File file=new File(path, mfile.getOriginalFilename());
			try {
				file.createNewFile();
				mfile.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "forward:show";
	}
	
	@RequestMapping("/show")
	public String show(HttpServletRequest request,HttpServletResponse response){
		String path=request.getServletContext().getRealPath("uploadfiles");
		File file=new File(path,"a.jpg");
		upService.readFile(file, response);
		
		return "show";
	}
	
}
