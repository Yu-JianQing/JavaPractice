package ch5;

import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		
		NoBug nobug=new NoBug();
		
		Class<?> nobugClass=nobug.getClass();
		
		Method[] methods=nobugClass.getDeclaredMethods();
		
		for(Method method:methods){
			if(method.isAnnotationPresent(Checkout.class)){
				method.setAccessible(true);
				try {
					method.invoke(nobug, null);
				} catch (Exception  e) {
					System.out.println(method.getName()+
							" has error caused by\n"+
							e.getCause().getClass().getSimpleName()+
							"\n"+e.getCause().getMessage());
				}
			}
		}
		
	}
}
