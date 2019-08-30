package ch4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	Object object;

	public ProxyFactory(Object object){
		this.object=object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
	public Object getProxy(){
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), 
				object.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						AddAspect addAspect=new AddAspect();
						
						addAspect.before();
						Object obj=method.invoke(object, args);
						addAspect.after((int)args[0], (int)args[1]);
						
						return obj;
					}
				});
		
	}
	
}
