package SanGS;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
	private final Queue<Request> queue=new LinkedList<Request>();
	private static final long timeout=3000L;//�ó�ʱ���������ɾ
	
	public synchronized Request getRequest(){
		long start=System.currentTimeMillis();//�ó�ʱ���������ɾ
		while(queue.peek()==null){
			try {
				long now=System.currentTimeMillis();				//�ó�ʱ���������ɾ
				long rest=timeout-(now-start);						//�ó�ʱ���������ɾ
				if(rest<=0)													//�ó�ʱ���������ɾ
					throw new RuntimeException();			//�ó�ʱ���������ɾ
				wait(rest);												//�ó�ʱ���������ɾ
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
