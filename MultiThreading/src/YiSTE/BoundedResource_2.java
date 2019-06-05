package YiSTE;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BoundedResource_2 {
	private final int count;
	private final Semaphore semaphore;
	private final static Random RANDOM=new Random(10000);
	
	public BoundedResource_2(int count){
		this.count=count;
		this.semaphore=new Semaphore(count);
	}
	
	public void use() throws Exception{
		semaphore.acquire();
		try {
			Log_2.println("begin: used="+(count-semaphore.availablePermits()));
			Thread.sleep(RANDOM.nextInt(500));
			Log_2.println("end: used="+(count-semaphore.availablePermits()));
		} finally {
			semaphore.release();
		}
	}
	
}
