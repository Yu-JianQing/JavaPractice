package BaWT_3;

import java.util.Random;

public class Request {
	private final String name;
	private int count;
	private final Random random=new Random();
	
	public Request(String name,int count){
		this.name=name;
		this.count=count;
	}
	
	public void execute(){
		System.out.println(Thread.currentThread().getName()+" execute "+this.toString());
//		try {
//			Thread.sleep(random.nextInt(1000));
//		} catch (InterruptedException e) {}
	}
	
	public String toString(){
		return "request is "+name+"it's number is"+count;
	}
}
