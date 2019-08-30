package ch4;

public class AddAspect {

	public void before(){
		System.out.println("before");
	}
	
	public void after(int i,int j){
		System.out.println("result="+(i+j));
	}
	
}
