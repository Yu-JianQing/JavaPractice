package ch4_4;

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
	
	@Pointcut("execution(* ch4_4.Print.print(..))")
	public void print(){}
	
	@Before("print()")
	public void before(){
		System.out.println("before");
	}
	
	@After("print()")
	public void after(){
		System.out.println("after");
	}
	
	@Around("print()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("qian");
		Object object=jp.proceed();
		System.out.println("hou");
		return object;
	}
	
}
