package ch9x3;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch9x3/")
public class ProductController {
	
	@Autowired
	private ProService proService;
	
	@RequestMapping("/input")
	public String input(Model model){
		model.addAttribute("product", new Product());
		return "shop";
	}
	
	@RequestMapping("/shop")
	public String shop(@Valid @ModelAttribute Product product,BindingResult result,Model model){
		if(result.hasErrors())
			return "shop";
		proService.save(product);
		model.addAttribute("products", proService.getProducts());
		return "show";
	}
	
}
