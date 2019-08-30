package MVC;

import javax.validation.Valid;

import org.apache.log4j.lf5.util.DateFormatManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.AddUserService;
import Test.User;

@Controller
@RequestMapping("/shopping/")
public class UserController {
	@Autowired
	AddUserService addUserService;
	
	@RequestMapping("/input")
	public String input(Model model){
		model.addAttribute("user", new User());
		return "adduser";
	}
	
	@RequestMapping("/adduser")
	public String adduser(@Valid @ModelAttribute User user,BindingResult result){
		DateFormatManager manager=new DateFormatManager("yyyy-MM-dd");
		String time=manager.format(new java.util.Date());
		System.out.println("the current time :"+time);
		
		if(result.hasErrors())
			return "adduser";
//		addUserService.addUser(user);
		addUserService.addUserByPeople(user);
		return "";
	}
	
}
