package ch4_3;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		User user=new User();
		
//		1.获取Class对象
		Class<?> c1=User.class;
		Class<?> c2=user.getClass();
		Class<?> c3=null;
		try {
			c3=Class.forName("ch4_3.User");
		} catch (ClassNotFoundException e) {}
		
		System.out.println(c1+"\n"+c2+"\n"+c3);
		
		
//		2.利用Class对象判断某对象是否为某个类的对象
		boolean b=c1.isInstance(user);
		System.out.println(b);
		
		
//		3.利用Class对象创建某个类的对象
//		利用了这个类的无参构造方法
		User user2=null;
		try {
			user2=(User) c2.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {}
		System.out.println(user2);

//		利用了这个类的有参构造方法
		User user3=null;
		try {
			Constructor<?> con=c3.getConstructor(String.class);
			user3=(User) con.newInstance("tom");
		} catch (Exception e) {}
		System.out.println(user3.getName());
		
		
//		4.利用Class对象获取类或接口中的方法
//		4.1获取所有方法除去继承的以及构造方法以外
		Method [] methods=c1.getDeclaredMethods();
		for(Method m:methods)
			System.out.println(m);
		System.out.println("*********");
		
//		4.2获取公共方法
		Method [] methods2=c2.getMethods();
		for(Method m:methods2)
			System.out.println(m);
		
//		4.3获取一个特定的方法
		Method method=null;
		try {
			method=c3.getMethod("getName", void.class);
			System.out.println(method);
		} catch (Exception e){}
		System.out.println("*********");
		
		
//		5.利用Class对象获取类的成员变量
//		5.1获取已声明的所有成员变量，除去继承的
		Field[] fields=c1.getDeclaredFields();
		for(Field field:fields)
			System.out.println(field);
		
//		5.2获取公有成员
		Field[] fields2=c2.getFields();
		for(Field field:fields2)
			System.out.println(field);
		
		
//		6.利用Class对象获取方法后调用
		try {
			Class<?> c4=User.class;
			Object obj=c4.newInstance();
			Method method2=c4.getMethod("setName", String.class);
			Object result=method2.invoke(obj, "jerry");
			System.out.println(result);
		} catch (Exception e){}
		
		
//		7.利用Class对象创建数组
		try {
			Class<?> c5=Class.forName("java.lang.String");
			Object array=Array.newInstance(c5, 10);
			Array.set(array, 0, "0");
			Array.set(array, 1, "1");
			Array.set(array, 2, "2");
			System.out.println(Array.get(array, 1));
		} catch (Exception e){}
		
		
	}
}
