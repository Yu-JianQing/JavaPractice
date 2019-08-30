package ch6;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch6/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/input")
	public String input(Model model){
		model.addAttribute("user",new User());

		HashMap<String, String> hobbys=new HashMap<String, String>();
		hobbys.put("ax1", "ax1");
		hobbys.put("ax2", "ax2");
		hobbys.put("ax3", "ax3");
		hobbys.put("ax4", "ax4");		
		model.addAttribute("hobbys", hobbys);
		
		model.addAttribute("carrers", new String[]{"bx1","bx2","bx3","bx4"});
		
		return "add";
	}
	
	@RequestMapping("/add")
	public String add(@ModelAttribute User user,Model model){
		if(userService.addUser(user)){
			return "redirect:show";}
		else{
			HashMap<String, String> hobbys=new HashMap<String, String>();
			hobbys.put("ax1", "ax1");
			hobbys.put("ax2", "ax2");
			hobbys.put("ax3", "ax3");
			hobbys.put("ax4", "ax4");
			model.addAttribute("hobbys", hobbys);
			
			model.addAttribute("carrers", new String[]{"bx1","bx2","bx3","bx4"});
		}
		
		return "add";
	}
	
	@RequestMapping("/show")
	public String show(Model model){
		List<User> users=userService.getUsers();
		model.addAttribute("users", users);
		return "show";
	}
	
}
