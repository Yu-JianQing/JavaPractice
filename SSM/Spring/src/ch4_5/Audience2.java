package ch4_5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience2 {
	
	@Pointcut("execution(** ch4_5.Performance.perform(..))")
	public void performance(){}
	
	@Before("performance()")
	public void BeforePerform(){
		System.out.println("before start");
	}
	
	@Before("performance()")
	public void Sit(){
		System.out.println("sit");
	}
	
	@After("performance()")
	public void AfterPerform(){
		System.out.println("pa pa pa ");
	}
	
	@AfterThrowing("performance()")
	public void PerformError(){
		System.out.println("perform error");
	}
	
}
