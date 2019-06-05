package SErActive_2;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

public class MakerClientThread extends Thread{
	private final ActiveObject activeObject;
	private final char fillchar;
	
	public MakerClientThread(ActiveObject activeObject,String name){
		super(name);
		this.activeObject=activeObject;
		this.fillchar=name.charAt(0);
	}

	public void run(){
		try {
			for (int i = 0; true; i++) {
				Future<String> future=activeObject.MakingString(i, fillchar);
				Thread.sleep(50);
				String value=future.get();
				System.out.println(Thread.currentThread().getName()+"  value :"+value);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName()+"  :  "+e);
		} catch (RejectedExecutionException e) {
			System.out.println(Thread.currentThread().getName()+"  :  "+e);
		}catch (CancellationException e) {
			System.out.println(Thread.currentThread().getName()+"  :  "+e);
		}catch (ExecutionException e) {
			System.out.println(Thread.currentThread().getName()+"  :  "+e);
		}
		
	}
}
