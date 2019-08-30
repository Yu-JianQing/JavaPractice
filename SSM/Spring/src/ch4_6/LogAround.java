package ch4_6;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAround {
	@Pointcut("execution(int ch4_6.Calculat.add(int,int))"+"&& args(i,j)")
	public int add(int i,int j){return 0;}
	
//	@Around("execution(int ch4_6.Calculat.add(int,int))"+"&& args(i,j)")
	@Around("add(i,j)")
	public int around(ProceedingJoinPoint pj,int i,int j){
		System.out.println("aaaaa"+i+j);
		try {
			pj.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println(22222);
		}
		return 0;
	}
}
