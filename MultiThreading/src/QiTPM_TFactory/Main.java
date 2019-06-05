package QiTPM_TFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) {
		ExecutorService executorService=Executors.newCachedThreadPool(new MyThreadFactory(false));
		for(int i=0;i<30;i++)
			executorService.execute(new TestRun(String.valueOf(i)));
		executorService.shutdown();
	}
	
	
	static class TestRun implements Runnable{
		private String msg;
		
		public TestRun(String msg){
			this.msg=msg;
		}
		
		public void run() {
			System.out.println(Thread.currentThread().getName()+"***"+msg);
		}
		
	}
}
