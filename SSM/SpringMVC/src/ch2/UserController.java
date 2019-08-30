package ch2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch2")
public class UserController {
	
	@RequestMapping("/login")
	public String login(Model model){
		model.addAttribute("user",new User());
		return "login";
	}
}
