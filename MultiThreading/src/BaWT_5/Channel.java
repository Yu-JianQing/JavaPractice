package BaWT_5;

public class Channel {
	private static final int Max_Request=100;
	private final WorkerThread [] threadPool;
	private final Request [] requests;
	private int head=0;
	private int tail=0;
	private int count=0;
	
	public Channel(int threads){
		threadPool=new WorkerThread[threads];
		requests=new Request[Max_Request];
		for (int i = 0; i < threadPool.length; i++) 
			threadPool[i]=new WorkerThread("Worker---"+i, this);
	}
	
	public void startWorkers(){
		for (int i = 0; i < threadPool.length; i++) 
			threadPool[i].start();
	}
	
	public void stopAllWorkers(){
		for (int i = 0; i < threadPool.length; i++) 
			threadPool[i].stopThread();
	}
	
	public synchronized void putRequest(Request request) throws InterruptedException{
		while(count>=requests.length)
			this.wait();
		requests[tail]=request;
		count++;
		tail=(tail+1)%requests.length;
		notifyAll();
	}
	
	public synchronized Request getRequest() throws InterruptedException{
		while(count<=0)
			this.wait();
		Request request=requests[head];
		head=(head+1)%requests.length;
		count--;
		notifyAll();
		return request;
	}
}
