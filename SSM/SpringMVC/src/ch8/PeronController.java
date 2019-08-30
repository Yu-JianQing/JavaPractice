package ch8;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ch6/")
public class PeronController {

	@RequestMapping("/input")
	@ResponseBody
	public Person input(@RequestBody Person person){
		System.out.println(person);
		return person;
	}
	
}
