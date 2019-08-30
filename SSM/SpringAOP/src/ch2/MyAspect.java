package ch2;

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
	
	@Before("execution(* ch2.Person.eat(String))"+"&& args(name)")
	public void before(String name){
		System.out.println(name+" before");
	}
	
	@After("execution(* ch2.Person.eat(String))"+"&& args(name)")
	public void after(String name){
		System.out.println(name+" after");
	}
	
	@Around("execution(* ch2.Person.eat(String))"+"&& args(name)")
	public void around(ProceedingJoinPoint point,String name){
		System.out.println("around before "+name);
		try {
			point.proceed();
		} catch (Throwable e) {
			System.out.println("around throw exception");
		}
		System.out.println("around after "+name);
	}
	
	/**************************************************/
	
	@Pointcut("execution(* ch2.Person.walk(..))")
	public void walk(){}
	
	@Before("walk()")
	public void before2(){
		System.out.println("walk before");
	}
	
	@After("walk()")
	public void after2(){
		System.out.println("walk after");
	}
	
	/******************************************************/
	
	@Pointcut("execution(* ch2.Person.hobbies(String,String))"+"&& args(h1,h2)")
	public void hobby(String h1,String h2){}
	
	@Before("hobby(h1,h2)")
	public void before3(String h1,String h2){
		System.out.println("hobby "+h1+h2+"before");
	}
	
	@After("hobby(h1,h2)")
	public void after3(String h1,String h2){
		System.out.println("hobby "+h1+h2+"after");
	}
}
