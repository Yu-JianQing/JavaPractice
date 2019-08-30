package ch1;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CountPerson implements HttpSessionListener, HttpSessionAttributeListener {
	ServletContext context;
	
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("session created");
    	HttpSession session=se.getSession();
    	session.setMaxInactiveInterval(10);
        context=session.getServletContext();
        if(context.getAttribute("count")==null)
        	context.setAttribute("count", 1);
        int count=(int) context.getAttribute("count");
        System.out.println("now the people count:"+count);
        count++;
        context.setAttribute("count", count);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("session destroy");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
         System.out.println("session add:"+se.getSession().getAttribute("name"));
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { //删除之后什么也获取不到，也就是说先删除再调用此方法
         System.out.println("session remove:"+se.getSession().getAttribute("name"));
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  {//替换就是指的向session中加入的值的key与原先有的相同
        System.out.println("attributeReplaced name"+se.getSession().getAttribute("name"));
    }
	
}
