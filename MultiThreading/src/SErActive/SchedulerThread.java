package SErActive;

public class SchedulerThread extends Thread{
	private final ActivationQueue queue;
	
	public SchedulerThread(ActivationQueue queue){
		this.queue=queue;
	}
	
	public void invoke(MethodRequest request){
		queue.putRequest(request);
	}
	
	public void run(){
		while(true){
			MethodRequest request=queue.getRequest();
			request.execute();
		}
	}
}
