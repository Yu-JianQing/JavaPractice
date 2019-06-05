package ShiTPT_5;

public class CountupThread extends GracefulThread{
	private long counter=0;

	protected void doWork() throws InterruptedException{
		counter++;
		System.out.println("do work counter "+counter);
		Thread.sleep(500);
	}
	
	protected void doShutdown(){
		System.out.println("shut down counter "+counter);
	}
}
