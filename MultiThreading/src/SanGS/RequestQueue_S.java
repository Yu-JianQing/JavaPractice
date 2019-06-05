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
			request=queue.poll(3L, TimeUnit.SECONDS); 						//�ó�ʱ���������ɾ
			if(request==null)  																//�ó�ʱ���������ɾ
				throw new TimeoutException();  								//�ó�ʱ���������ɾ
//			request=queue.take();
		} catch (Exception e) {
			System.out.println(e);
		}
		return request;
	}
	
	public void putRequest(Request request){
		try {
			boolean flag=queue.offer(request, 3L, TimeUnit.SECONDS); 						//�ó�ʱ���������ɾ
			if(flag==false) 																						//�ó�ʱ���������ɾ
				throw new TimeoutException();  														//�ó�ʱ���������ɾ
//			queue.put(request);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
