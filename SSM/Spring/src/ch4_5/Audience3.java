package ch4_5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience3 {
	@Pointcut("execution(** ch4_5.Performance.perform(..))")
	public void performance(){}
	
	@Around("performance()")
	public void watch(ProceedingJoinPoint joinPoint){
		try {
			System.out.println("before");
			System.out.println("sit");
			joinPoint.proceed();
			System.out.println("pa pa pa");
		} catch (Throwable e) {
			System.out.println("perform error");
		}
		
	}
	
}
