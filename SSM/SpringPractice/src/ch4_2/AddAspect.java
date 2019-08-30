package ch4_2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AddAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("before");
		
		Object object=arg0.proceed();
		
		Object[] args=arg0.getArguments();
		
		System.out.println("result="+((int)args[0]+(int)args[1]));
		
		return object;
	}
	
}
