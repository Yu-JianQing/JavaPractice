package ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/")
public class XController {
	@Autowired
	TestService service;
	
	@RequestMapping("/test")
	public void test(){
		service.service();
	}
}
