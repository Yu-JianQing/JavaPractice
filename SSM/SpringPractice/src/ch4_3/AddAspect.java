package ch4_3;

import org.aspectj.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AddAspect {
	
	public void before(JoinPoint jp){
		System.out.println("before");
		System.out.println("目标对象："+jp.getTarget());
		System.out.println("扩展的目标对象方法："+jp.getSignature().getName());
	}
	
	public void after(JoinPoint jp){
		System.out.println("after");
	}
	
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("环绕前");
		
		Object obj=jp.proceed();
		
		System.out.println("环绕后");
		
		return obj;
	}
	
	public void error(Throwable e){
		System.out.println("yi==");
	}
	
}
