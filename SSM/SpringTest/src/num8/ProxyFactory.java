package num8;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor{
	private Object target;
	
	public void setTarget(Object target) {
		this.target = target;
	}

	public ProxyFactory(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("tom before");
		
		Object obj=methodProxy.invokeSuper(proxy, args);
		
		System.out.println("tom after");
		return obj;
	}
	
	public Object getProxy(){
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

}
