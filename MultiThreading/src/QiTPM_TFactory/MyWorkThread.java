package QiTPM_TFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class MyWorkThread extends Thread{
	private AtomicInteger atomicInteger;
	
	public MyWorkThread(AtomicInteger atomicInteger,Runnable r){
		super(r);
		this.atomicInteger=atomicInteger;
	}
	
	public void run(){
		System.out.println("I am "+this.getName()+"   "+atomicInteger.getAndIncrement());
		super.run();
	}
}
