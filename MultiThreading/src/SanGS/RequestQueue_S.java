package SanGS;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestQueue_S {
	private final BlockingQueue<Request> queue=new LinkedBlockingQueue<Request>();
	
	public Request getRequest(){
		Request request=null;
		try {
			request=queue.poll(3L, TimeUnit.SECONDS); 						//用超时检查死锁可删
			if(request==null)  																//用超时检查死锁可删
				throw new TimeoutException();  								//用超时检查死锁可删
//			request=queue.take();
		} catch (Exception e) {
			System.out.println(e);
		}
		return request;
	}
	
	public void putRequest(Request request){
		try {
			boolean flag=queue.offer(request, 3L, TimeUnit.SECONDS); 						//用超时检查死锁可删
			if(flag==false) 																						//用超时检查死锁可删
				throw new TimeoutException();  														//用超时检查死锁可删
//			queue.put(request);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
