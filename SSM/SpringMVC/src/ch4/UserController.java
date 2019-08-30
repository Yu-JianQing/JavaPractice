package ch4;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch4")
public class UserController {
	@Autowired
	private UserService UserService;
	
	@RequestMapping("/login")
	public String login(User user,HttpSession session,Model model){
		if(UserService.login(user)){
			session.setAttribute("s", "s");
			model.addAttribute("s", "s");
			return "test";
		}else {
			session.setAttribute("d","d");
			model.addAttribute("d","d");
			return "login";
		}
	}
}
