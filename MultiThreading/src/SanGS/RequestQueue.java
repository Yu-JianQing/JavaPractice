package SanGS;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
	private final Queue<Request> queue=new LinkedList<Request>();
	private static final long timeout=3000L;//用超时检查死锁可删
	
	public synchronized Request getRequest(){
		long start=System.currentTimeMillis();//用超时检查死锁可删
		while(queue.peek()==null){
			try {
				long now=System.currentTimeMillis();				//用超时检查死锁可删
				long rest=timeout-(now-start);						//用超时检查死锁可删
				if(rest<=0)													//用超时检查死锁可删
					throw new RuntimeException();			//用超时检查死锁可删
				wait(rest);												//用超时检查死锁可删
//				wait();
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
