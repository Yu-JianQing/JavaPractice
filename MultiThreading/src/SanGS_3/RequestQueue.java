package SanGS_3;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
	private final Queue<Request> queue=new LinkedList<Request>();
	
	public synchronized Request getRequest(){
		while(queue.peek()==null){
			try {
				wait();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return queue.remove();
	}
	
	public synchronized void putRequest(Request request){
		queue.offer(request);
		notifyAll();
	}
}
