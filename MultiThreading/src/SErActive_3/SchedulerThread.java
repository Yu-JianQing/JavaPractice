package SErActive_3;

public class SchedulerThread extends Thread{
	private final ActivationQueue queue;
	
	public SchedulerThread(ActivationQueue queue,String name){
		super(name);
		this.queue=queue;
	}
	
	public void invoke(MethodRequest request){
		queue.putRequest(request);
	}
	
	public void run(){
		MethodRequest request=queue.getRequest();
		request.execute();
	}
}
