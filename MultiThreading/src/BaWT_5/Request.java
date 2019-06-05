package BaWT_5;

import java.util.Random;

public class Request {
	private final String name;
	private final int number;
	private static final Random random=new Random();
	
	public Request(String name,int number){
		this.name=name;
		this.number=number;
	}
	
	public void execute() throws InterruptedException{
		System.out.println(Thread.currentThread().getName()+"execute"+this);
		Thread.sleep(random.nextInt(1000));
	}
	
	public String toString(){
		return "request from"+name+"          NO."+number;
	}
}
