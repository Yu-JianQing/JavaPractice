package BaWT_5;

public class WorkerThread extends Thread{
	private final Channel channel;
	
	public WorkerThread(String name,Channel channel){
		super(name);
		this.channel=channel;
	}
	
	public void stopThread(){
		this.interrupt();
	}
	
	public void run(){
		try {
			while(true){
				Request request=channel.getRequest();
				request.execute();
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()+"  is terminated");
		}
	}
}
