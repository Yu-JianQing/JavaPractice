package ch5;

public class NoBug {
	
	@Checkout
	public void add(){
		System.out.println("1+1="+(1+1));
	}
	
	@Checkout
	public void decrease(){
		System.out.println("8-2="+(8-2));
	}
	
	@Checkout
	public void chu(){
		System.out.println("5/0"+(5/0));
	}
	
}
