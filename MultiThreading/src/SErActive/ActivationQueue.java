package SErActive;

public class ActivationQueue {
	private static final int Max_Method_Request=100;
	private final MethodRequest[] requestQueue;
	private int head=0;
	private int tail=0;
	private int count=0;
	
	public ActivationQueue(){
		this.requestQueue=new MethodRequest[Max_Method_Request];
	}
	
	public synchronized void putRequest(MethodRequest request){
		while(count>=Max_Method_Request){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		requestQueue[tail]=request;
		this.tail=(tail+1)%requestQueue.length;
		this.count++;
		notifyAll();
	}
	
	public synchronized MethodRequest getRequest(){
		while(count<=0){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		MethodRequest request=requestQueue[head];
		this.head=(head+1)%requestQueue.length;
		this.count--;
		notifyAll();
		return request;
	}
}
