package ch5_2;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("ch5_2")
public class UserControl {
	private static final Log  LOG=LogFactory.getLog(UserControl.class);
	
//	@RequestMapping("/register")
	public String register(User user,Model model){
		if("x".equals(user.getName())&&"123".equals(user.getPass())){
			LOG.info("success");
			return "login";
		}else{
			LOG.info("fault");
			model.addAttribute("name",user.getName());
			return "register";
		}
	}
	
//	@RequestMapping("/login")
	public String login(User user,HttpSession session,Model model){
		if("x".equals(user.getName())&&"123".equals(user.getPass())){
			session.setAttribute("user", user);
			LOG.info("success");
			return "main";
		}else{
			LOG.info("fault");
			model.addAttribute("msg","error");
			return "login";
		}
	}

}
