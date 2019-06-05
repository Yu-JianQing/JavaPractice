package BaWT_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newFixedThreadPool(5);
		try {
			new ClientThread("Tom", executorService).start();
			new ClientThread("Jerry", executorService).start();
			new ClientThread("Bob", executorService).start();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}finally{
			executorService.shutdown();
		}
		
	}
}
