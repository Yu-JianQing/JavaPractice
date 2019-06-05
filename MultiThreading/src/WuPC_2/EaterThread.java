package WuPC_2;

import java.util.concurrent.SynchronousQueue;

public class EaterThread extends Thread{
	private final SynchronousQueue<String> queue;
	
	public EaterThread(String name,SynchronousQueue<String> queue){
		super(name);
		this.queue=queue;
	}
	
	public void run(){
		try {
			while(true){
				String cake=queue.take();
				System.out.println(Thread.currentThread().getName()+"     eat a     "+cake);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
