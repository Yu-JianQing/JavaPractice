package ch4_2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyF {
	
	private Object target;

	public ProxyF(Object target){
		this.target=target;
	}
	
	public void setObject(Object target) {
		this.target = target;
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println(111111);
						Object obj=method.invoke(target, args);
						System.out.println(22222222);
						
						return obj;
					}
				});
	}
	
}
