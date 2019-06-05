package SErActive_2;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

public class AddClientThread extends Thread{
	private final  ActiveObject activeObject;
	
	public AddClientThread(ActiveObject activeObject,String name){
		super(name);
		this.activeObject=activeObject;
	}
	
	public void run(){
		int i=1,j=1,sum=0;
		while(true){
			Future<String> future=activeObject.Add(String.valueOf(i), String.valueOf(j));
			try {
				sum=Integer.parseInt(future.get());
				System.out.println(i+"  +  "+j+"  =  "+sum);
				Thread.sleep(100);
			}catch (RejectedExecutionException e) {
				System.out.println(Thread.currentThread().getName()+"  :  "+e);
			}catch (CancellationException e) {
				System.out.println(Thread.currentThread().getName()+"  :  "+e);
			}catch (NumberFormatException | InterruptedException| ExecutionException e) {
				System.out.println(Thread.currentThread().getName()+"  :  "+e);
			}
			i=j;
			j=sum;
		}
	}
	
}
