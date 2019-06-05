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
				System.out.println(Thread.currentThread().getName()+"     put a     cake");//�˾仰��λ��ֻ�����⣬�ڱ�ĵط������ӳ�
				queue.put("cake");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
