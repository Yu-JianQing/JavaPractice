package SanGS_2;

import java.util.Random;

public class ServerThread extends Thread{
	private final RequestQueue requestQueue;
	private final Random random;
	
	public ServerThread(String name,RequestQueue requestQueue,long seed){
		super(name);
		this.requestQueue=requestQueue;
		this.random=new Random(seed);
	}
	
	public void run(){
		try {
			for (int i = 0; i <10000; i++) {
				Request request=requestQueue.getRequest();
				System.out.println(Thread.currentThread().getName()+"   handle   "+request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
