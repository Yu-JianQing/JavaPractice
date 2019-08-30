package ch3;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* ch3.TestService.service(..))")
	public void service(){}
	
	@Before("service()")
	public void before(){
		System.out.println("test before");
	}
	
	@After("service()")
	public void after(){
		System.out.println("test after");
	}
}
