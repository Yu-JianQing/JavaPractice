package ch3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch3")
public class ProController {
	@RequestMapping("/shop")
	public String shop(Model model,double price,int count){
		double total=price*count;System.out.println(total);
		model.addAttribute("pro",total);
		return "test";
	}
}
