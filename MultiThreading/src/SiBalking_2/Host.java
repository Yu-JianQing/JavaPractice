package SiBalking_2;

import java.util.concurrent.TimeoutException;

public class Host {
	private final long timeout;
	private boolean ready=false;
	
	public Host(long timeout){
		this.timeout=timeout;
	}
	
	public synchronized void setState(boolean on){
		ready=on;
		notifyAll();
	}
	
	private void doExecute(){
		System.out.println(Thread.currentThread().getName()+"***doExcecute***");
	}
	
	public synchronized void execute() throws InterruptedException,TimeoutException{
		long start=System.currentTimeMillis();
		while(!ready){
			long now=System.currentTimeMillis();
			long rest=timeout-(now-start);
			if(rest<=0)
				throw new TimeoutException("now-start="+(now-start)+"     timeout="+timeout);
			wait(rest);//有wait就一定要有锁
		}
		doExecute();
	}
}
