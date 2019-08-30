package ch5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ch5")
public class ProCntroller {
	@RequestMapping("/shop")
	public String shop(@RequestParam String pro, Model model){System.out.println(111);
	ProductConverter converter=new ProductConverter();
	Product product=converter.convert(pro);
	model.addAttribute("pro",product);
	return "test";
}
}
