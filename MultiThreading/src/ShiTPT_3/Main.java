package ShiTPT_3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	private static final int TASKS=10;
	
	public static void main(String[] args) {
		System.out.println("begin");
		
		ExecutorService service=Executors.newFixedThreadPool(5);
		CountDownLatch doneLatch=new CountDownLatch(TASKS);
		
		try {
			for (int i = 0; i < TASKS; i++) 
				service.execute(new MyTask(doneLatch,i));
			
			System.out.println("**********await*********");
			
			doneLatch.await();
		} catch (InterruptedException e) {
		}finally{
			service.shutdown();
			System.out.println("end");
		}
		
	}
}
