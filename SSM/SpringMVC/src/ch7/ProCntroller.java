package ch7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch7")
public class ProCntroller {
	@RequestMapping("/shop")
	public String shop(Product product, Model model){
		model.addAttribute("product", product);
		return "test";
	}
}
