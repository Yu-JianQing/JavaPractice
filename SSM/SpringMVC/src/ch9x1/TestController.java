package ch9x1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch9x1/")
public class TestController {
	
	@RequestMapping("/gotest")
	public String goTest(){
		System.out.println("controller --- interceptor test");
		return "test";
	}
	
}
