package ch9x2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch9x2/")
public class ProductController {
	
	@Autowired
	private ProService proService;
	
	@Resource
	private ProductValidator validator;
	
	@RequestMapping("/input")
	public String input(Model model){
		model.addAttribute("product", new Product());
		return "shop";
	}
	
	@RequestMapping("/shop")
	public String shop(@ModelAttribute Product product,BindingResult result,Model model){
		this.validator.validate(product, result);//添加验证
		
		if(result.hasErrors())
			return "shop";
		proService.save(product);
		model.addAttribute("products", proService.getProducts());
		return "show";
	}
	
}
