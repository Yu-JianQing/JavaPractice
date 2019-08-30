package numx3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

	public void before(JoinPoint jp,String h1,String h2){
		System.out.println("before & target:"+jp.getTarget());
		System.out.println("before "+h1+h2);
	}
	
	public void after(JoinPoint jp,String h1,String h2){
		System.out.println("after & Signature:"+jp.getSignature().getName());
	}
	
	public Object around(ProceedingJoinPoint jp,String h1,String h2) throws Throwable{
		System.out.println("around before");
		
		Object obj=jp.proceed();
		
		System.out.println("around after");
		return obj;
	}
	
}
