package ch9x7;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ch9x7/")
public class FileDownController {
	
	@RequestMapping("/show")
	public String show(HttpServletRequest request,Model model){
		String path=request.getServletContext().getRealPath("uploadfiles");
		
		File file=new File(path);
		File files[]=file.listFiles();
		
		List<String> names=new ArrayList<String>();
		for(File f:files){
			names.add(f.getName());
		}
		
		model.addAttribute("names", names);
		
		return "show";
	}
	
	@RequestMapping("/down")
	public String down(@RequestParam String fname,HttpServletRequest request,HttpServletResponse response){
		String path=null;
		FileInputStream in=null;
		ServletOutputStream out=null;
		
		try {
			path=request.getServletContext().getRealPath("uploadfiles");
			
			response.setHeader("Content-Type", "application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename="+fname);
			
			in=new FileInputStream(path+"\\"+fname);
			out=response.getOutputStream();
			out.flush();
			
			int r=0;byte b[]=new byte[1024]; 
			while((r=in.read(b))!=-1){
				out.write(b,0,r);
			}
			out.flush();
			in.close();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
