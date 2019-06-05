package QiTPM_TFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory{
	private AtomicInteger atomicInteger=new AtomicInteger();
	private boolean isDeamon;

	public MyThreadFactory(boolean isDeamon){
		this.isDeamon=isDeamon;
	}
	
	@Override
	public Thread newThread(Runnable r) {
		Thread thread=new MyWorkThread(atomicInteger,r);
		thread.setDaemon(isDeamon);
		return thread;
	}

}
