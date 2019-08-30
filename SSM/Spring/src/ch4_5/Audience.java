package ch4_5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {
	
	@Before("execution(** ch4_5.Performance.perform(..))")
	public void BeforePerform(){
		System.out.println("before start");
	}
	
	@Before("execution(** ch4_5.Performance.perform(..))")
	public void Sit(){
		System.out.println("sit");
	}
	
	@After("execution(** ch4_5.Performance.perform(..))")
	public void AfterPerform(){
		System.out.println("pa pa pa ");
	}
	
	@AfterThrowing("execution(** ch4_5.Performance.perform(..))")
	public void PerformError(){
		System.out.println("perform error");
	}
	
}
