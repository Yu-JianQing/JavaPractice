package ch5_2;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch5_2")
public class UserControl3 {
	private static final Log  LOG=LogFactory.getLog(UserControl3.class);
	
//	@RequestMapping("/register")
//	public String register(){
//		return "test";//相当于跳转，请求处理完毕后跳转到一个视图。地址栏中的URL不变。
//	}
	
//	@RequestMapping("/register")
//	public String register(String name){
//		return "forward:/ch5_2/test.jsp";//请求转发。可以传递多次参数，只要是一个request即可。地址栏中的URL不变。
										//注意：转发到的页面要加上jsp后缀
//	}
	
	@RequestMapping("/register")
	public String register(){
		return "redirect:test.jsp";//请求重定向。不可以传递参数。地址栏中的URL变成定向到的页面。同样注意加jsp后缀。
	}
	
}
