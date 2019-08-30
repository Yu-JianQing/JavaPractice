package ch4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ch1.Check;
import ch1.TestAnno;
import ch3.Tom;

@TestAnno(msg="hello")
public class Test {
	
	@Check("HELLO")
	int a;
	
	@Perform
	public void testMethod(){}
	
	@SuppressWarnings("deprecation")
	public void test1(){
		Tom tom=new Tom();
		tom.say();
		tom.speak();
	}
	
	
	
	public static void main(String[] args) {
		
		boolean hasAnnotation=Test.class.isAnnotationPresent(TestAnno.class);
		
		if(hasAnnotation){
			TestAnno testAnno=Test.class.getAnnotation(TestAnno.class);
			
			System.out.println("id="+testAnno.id());
			
			System.out.println("msg="+testAnno.msg());
		}
		
		/*****************************/
		
		try {
			Field field=Test.class.getDeclaredField("a");
			field.setAccessible(true);
			
			Check check=field.getAnnotation(Check.class);//注解还能当类用
			
			if(check!=null)
				System.out.println("check value:"+check.value());
			
			//
			Method method=Test.class.getMethod("testMethod");
			
			if(method!=null){
				Annotation[] ans=method.getAnnotations();
				for(Annotation an:ans)
					System.out.println("testmethod annotaion:"+an);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
