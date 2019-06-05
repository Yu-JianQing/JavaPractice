package SErActive_2;

import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;

public class DisplayClientThread extends Thread{
	private final ActiveObject activeObject;
	
	public DisplayClientThread(ActiveObject activeObject,String name){
		super(name);
		this.activeObject=activeObject;
	}
	
	public void run(){
		try {
			for (int i = 0; true; i++) {
				String string=Thread.currentThread().getName()+"  : "+i;
				activeObject.DisplayString(string);
				Thread.sleep(500);
			}
		} catch (RejectedExecutionException e) {
			System.out.println(Thread.currentThread().getName()+"  :  "+e);
		}catch (CancellationException e) {
			System.out.println(Thread.currentThread().getName()+"  :  "+e);
		}catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()+"  :  "+e);
		}
	}
}
