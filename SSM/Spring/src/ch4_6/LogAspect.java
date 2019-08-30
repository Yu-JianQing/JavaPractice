package ch4_6;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	@Pointcut("execution(int ch4_6.Calculat.add(int,int))"+"&& args(i,j)")
	public void add(int i,int j){}
	
	@Before("add(i,j)")
	public void AddBefore(int i,int j){
		System.out.println("add before"+i+j);
	}
	
	@After("add(i,j)")
	public void AddAfter(int i,int j){
		System.out.println("add after"+i+j);
	}
	
	@AfterThrowing("add(i,j)")
	public void AddError(int i,int j){
		System.out.println("add error");
	}
	
	
}
