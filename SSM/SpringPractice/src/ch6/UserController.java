package ch6;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch6")
public class UserController {
	private static final Log LOG=LogFactory.getLog(UserController.class);
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/register")
	public String register(User user,HttpSession session){
		session.setAttribute("name", user.getName());
		if(service.register(user))
			return "test";
		else
			return "register";
	}
	
	
}
