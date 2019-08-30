package ch4_1;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor{
	Object object;
	
	public ProxyFactory(Object object) {
		this.object = object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	public Object getProxy(){
		Enhancer enhancer=new Enhancer();
		
		enhancer.setSuperclass(object.getClass());
		enhancer.setCallback(this);
		
		return enhancer.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("before");
		
		Object obj=methodProxy.invokeSuper(proxy, args);
		
		System.out.println((int)args[0]+(int)args[1]);
		return obj;
	}

}
