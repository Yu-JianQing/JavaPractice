package ShiTPT;

public class CountupThread extends Thread{
	private long counter=0;
	private volatile boolean shutDownRequest=false;
	
	public void shutdownRequest(){
		shutDownRequest=true;
		interrupt();
	}
	
	public boolean isShutdownRequest(){
		return shutDownRequest;
	}
	
	private void doWork() throws InterruptedException{
		counter++;
		System.out.println("do work counter "+counter);
		Thread.sleep(500);
	}
	
	private void doShutdown(){
		System.out.println("shut down counter "+counter);
	}
	
	public void run(){
		try {
			while(!isShutdownRequest())
				doWork();
		} catch (InterruptedException e) {
		}finally{
			doShutdown();
		}
	}
}
