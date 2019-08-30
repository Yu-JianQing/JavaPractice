package ch5;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor{
	private Object target;
	
	public ProxyFactory(Object target){
		this.target=target;
	}
	
	public Object getProxy(){
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args,MethodProxy methodProxy) throws Throwable {
		System.out.println("before");
		Object object=methodProxy.invokeSuper(proxy, args);
		System.out.println("after");
		return object;
	}
}
