package ShiTPT_4;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	private static final int THREADS=3;
	
	public static void main(String[] args) {
		System.out.println("begin");
		
		ExecutorService service=Executors.newFixedThreadPool(THREADS);
		
		Runnable barrierAction=new Runnable() {
			public void run() {
				System.out.println("barrier   Action!");
			}
		};
		
		CyclicBarrier phaseBarrier=new CyclicBarrier(THREADS,barrierAction);
		
		CountDownLatch donelLatch=new CountDownLatch(THREADS);
		
		try {
			for (int i = 0; i < THREADS; i++) 
				service.execute(new MyTask(phaseBarrier,donelLatch,i));
			
			System.out.println("await");
			donelLatch.await();
		} catch (InterruptedException e) {
		}finally{
			service.shutdown();
			System.out.println("end");
		}
	}
}
