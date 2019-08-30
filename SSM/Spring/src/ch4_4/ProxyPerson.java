package ch4_4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyPerson {
	private Person tom=new RealPerson();
	
	public Person getProx(){
		Person person=(Person) Proxy.newProxyInstance(
				ProxyPerson.class.getClassLoader(),
				tom.getClass().getInterfaces(), 
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("pppppp");
						return method.invoke(tom, args);
					}
				});
		
		return person;
	}
	
	
}
