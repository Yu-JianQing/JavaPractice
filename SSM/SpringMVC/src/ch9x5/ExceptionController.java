package ch9x5;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch9x5/")
public class ExceptionController extends BaseController{
	@Autowired
	private ExceptionService exceptionService;
	
	@RequestMapping("/db")
	public void db()throws Exception{
		throw new SQLException("controller:sql error");
	}
	
	@RequestMapping("/my")
	public void my() throws Exception{
		throw new MyException("controller:my error");
	}
	
	@RequestMapping("/no")
	public void no() throws Exception{
		throw new Exception("controller:don't know error");
	}
	
	@RequestMapping("/servicedb")
	public void servicedb()throws Exception{
		exceptionService.servicedb();
	}
	
	@RequestMapping("/servicemy")
	public void servicemy() throws Exception{
		exceptionService.servicemy();
	}
	
	@RequestMapping("/serviceno")
	public void serviceno() throws Exception{
		exceptionService.serviceno();
	}
	
	@RequestMapping("/daodb")
	public void daodb()throws Exception{
		exceptionService.db();
	}
	
	@RequestMapping("/daomy")
	public void daomy() throws Exception{
		exceptionService.my();
	}
	
	@RequestMapping("/daono")
	public void daono() throws Exception{
		exceptionService.no();
	}
	
}
