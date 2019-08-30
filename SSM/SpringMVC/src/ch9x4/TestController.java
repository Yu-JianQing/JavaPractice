package ch9x4;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch9x4/")
public class TestController {
	
	@RequestMapping("/test")
	public String test(Locale locale){
		return "first";
	}
	
	@RequestMapping("/first")
	public String first(){
		return "first";
	}
	
	@RequestMapping("/second")
	public String second(){
		return "second";
	}
	
	@RequestMapping("/third")
	public String third(){
		return "third";
	}
	
}
