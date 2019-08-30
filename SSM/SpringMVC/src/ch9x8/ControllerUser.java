package ch9x8;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch9x8/")
public class ControllerUser {
	
	@RequestMapping("/input")
	public String input(POUser user,Model model){
		ApplicationContext context=new ClassPathXmlApplicationContext("ch9x8/applicationConfig.xml");
		
		DaoUser userMapper=(DaoUser) context.getBean("userMapper");
		List<POUser> users=userMapper.selectUserByUname(user);
		model.addAttribute("users", users);
		return "show";
	}
	
	
}
