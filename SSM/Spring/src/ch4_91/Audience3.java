package ch4_91;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Audience3 {
	
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
