package BaWT;

public class WorkerThread extends Thread{
	private final Channel channel;
	
	public WorkerThread(String name,Channel channel){
		super(name);
		this.channel=channel;
	}
	
	public void run(){
		while(true){
			Request request=channel.getRequest();
			request.execute();
		}
	}
}
