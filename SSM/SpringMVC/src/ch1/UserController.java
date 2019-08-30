package ch1;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch1")
public class UserController {
	private List<User> users=new ArrayList<User>();
	
	@RequestMapping("/register")
	public String register(Model model,@Valid User user,Errors errors){
		if(errors.hasErrors()){
			return "register";
		}
		users.add(user);
		model.addAttribute("users", users);
		return "test";
	}
}
