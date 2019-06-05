package WuPC_2;

import java.util.concurrent.SynchronousQueue;

public class MakerThread extends Thread{
	private final SynchronousQueue<String> queue;
	
	public MakerThread(String name,SynchronousQueue<String> queue){
		super(name);
		this.queue=queue;
	}
	
	public void run(){
		try {
			while(true){
				System.out.println(Thread.currentThread().getName()+"     put a     cake");//此句话的位置只能在这，在别的地方会有延迟
				queue.put("cake");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
