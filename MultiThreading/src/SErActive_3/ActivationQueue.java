package SErActive_3;

public class ActivationQueue {
	private static final int Max=100;
	private final MethodRequest [] requests;
	private int head=0,tail=0,count=0;
	
	public ActivationQueue(){
		this.requests=new MethodRequest[Max];
	}
	
	public synchronized void putRequest(MethodRequest request){
		try {
			if(requests.length>Max)
				wait();
			requests[tail]=request;
			tail=(tail+1)%requests.length;
			count++;
			notifyAll();
		} catch (InterruptedException e) {}
	}
	
	public synchronized MethodRequest getRequest(){
		MethodRequest request = null;
		try {
			if(count<0)
				wait();
			request=requests[head];
			head=(head+1)%requests.length;
			count--;
		} catch (InterruptedException e) {}
		return request;
	}
	
}
