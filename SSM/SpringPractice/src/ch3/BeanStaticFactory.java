package ch3;

public class BeanStaticFactory {
private static Bean bean2=new Bean("i am bean2");
	
	public static Bean createBean(){
		return bean2;
	}
}
