package num9;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* num9.Person.Hobbits(String,String))"+"&& args(h1,h2)")//返回值为list最好写*
	public List<String> Hobbits(String h1,String h2){return null;}
	
	@Before("Hobbits(h1,h2)")
	public void before(String h1,String h2){
		System.out.println("before"+"  "+h1+"   "+h2);
	}
	
	@After("Hobbits(h1,h2)")
	public void after(String h1,String h2){
		System.out.println("after"+"  "+h1+"   "+h2);
	}
	
	@Around("Hobbits(h1,h2)")
	public Object around(ProceedingJoinPoint jp,String h1,String h2) throws Throwable{
		System.out.println("around before");
		
		Object obj=jp.proceed();
		
		System.out.println("around after");
		return obj;
	}
	
	
}
