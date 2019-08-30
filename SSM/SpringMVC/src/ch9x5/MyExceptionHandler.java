package ch9x5;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, 
														Object object, Exception exception) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("exception", exception);
		
		if(exception instanceof MyException)
			return new ModelAndView("myerror",map);
		else if(exception instanceof SQLException)
			return new ModelAndView("dberror",map);
		else
			return new ModelAndView("error",map);
		
	}

}
