package MVC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shopping")
public class DownController {
	
	@RequestMapping("/downinput")
	public String downinput(Model model){
		model.addAttribute("name", "x.exe");
		return "down";
	}
	
	@RequestMapping("/down")
	public void down(@RequestParam String name,HttpServletRequest request,HttpServletResponse response) throws Exception{
		File file=new File("D:\\英魂\\"+name);
		FileInputStream in=new FileInputStream(file);
		OutputStream out=response.getOutputStream();
		
		response.setHeader("Content-Type", "application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment;filename="+name);
		
		byte b[]=new byte[1000000];int n=0;
		while((n=in.read(b))!=-1){
			out.write(b, 0, n);
		}
		
	}
}
