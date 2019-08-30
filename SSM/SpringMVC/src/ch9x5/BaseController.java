package ch9x5;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {

	@ExceptionHandler
	public String exception(HttpServletRequest request,Exception exception){
		request.setAttribute("exception", exception);
		
		if(exception instanceof MyException)
			return "myerror";
		else if(exception instanceof SQLException)
			return "dberror";
		else
			return "error";
		
	}
	
}
