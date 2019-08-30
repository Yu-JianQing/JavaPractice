package ch5_2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
//@RequestMapping("ch5_2")
public class UserControl2 {
	private static final Log  LOG=LogFactory.getLog(UserControl2.class);
	
//	@RequestMapping("/register")//通过实体bean接收请求参数的值，此时bean中的相应属性名必须与请求参数名字相同
//	public String register(User user){
//		String s=user.getName()+user.getPass()+user.getRepass();
//		LOG.info(s);
//		return "test";
//	}
	
//	@RequestMapping("/register")//通过形参接收请求参数的值，此时形参名必须与请求参数名字相同
//	public String register(String name,String pass,String repass){
//		String s=name+pass+repass;
//		LOG.info(s);
//		return "test";
//	}
	
	
//	@RequestMapping("/register")//通过request接收请求参数的值，因为请求的提交就是将信息封装到rquest中
//	public String register(HttpServletRequest request){
//		String name=request.getParameter("name");
//		String pass=request.getParameter("pass");
//		String repass=request.getParameter("repass");
//		String s=name+pass+repass;
//		LOG.info(s);
//		return "test";
//	}
	
//	@RequestMapping(value="/register/{name}/{pass}/{repass}",method=RequestMethod.GET)
//	//get方式会将请求参数显式地暴露在请求路径中
//	//通过从get方式获取的请求路径中的某些部分来接收相应的参数值。此时requestmapping中必须指明请求方式为get，
//	//并且处理的请求路径必须按照get方式写全，在路径中用｛站位｝来接收请求参数值
//	public String register(@PathVariable String name,@PathVariable String pass,@PathVariable String repass){
//		String s=name+pass+repass;
//		LOG.info(s);
//		return "test";
//	}	
	
//	@RequestMapping("/register")//通过@requestparam形参接收请求参数的值，此时形参名必须与请求参数名字相同
//	//与普通形参接收区别：普通的即使形参名与请求参数名不同也不会报错，接收到的参数值默认为null。
//	//@requestparam形参名与请求参数名不同会报400错误
//	public String register(@RequestParam String name,@RequestParam String pass,@RequestParam String repass){
//		String s=name+pass+repass;
//		LOG.info(s);
//		return "test";
//	}
	
//	@RequestMapping("/register")
//	//通过@ModelAttribute将多个请求参数封装到一个实体对象中来接收参数值，此对象中的相应属性名必须与请求参数名字相同
//	//（@ModelAttribute（“key”）参数类型 参数）作为形参相当于model.addAttribute("key",参数)
//	//与实体bean接收区别：类似，只不过封装对象不同
//	public String register(@ModelAttribute("user") User user){
//		String s=user.getName()+user.getPass()+user.getRepass();
//		LOG.info(s);
//		return "test";
//	}
	
}
