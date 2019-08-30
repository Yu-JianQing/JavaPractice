package ch9;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch9/")
public class ELController {
	
	@RequestMapping("/ELinput")
	public String ELinput(Model model,HttpServletRequest request,HttpSession session){
		Person tom1=new Person("tom1","123",12,"man");
		model.addAttribute("tom1", tom1);
		
		Person tom2=new Person("tom2","124",13,"man");
		request.setAttribute("tom2", tom2);
		
		Person tom3=new Person("tom3","125",14,"man");
		session.setAttribute("tom3", tom3);
		
		ServletContext application=request.getServletContext();
		Person tom4=new Person("tom4","126",15,"man");
		application.setAttribute("tom4", tom4);
		
		return "ELshow";
	}
	
	
	@RequestMapping("/JSTLinput")
	public String JSTLinput(Model model){
		Person tom1=new Person("tom1","123",12,"man");
		model.addAttribute("tom1", tom1);
		
		return "JSTLshow";
	}
	
}
