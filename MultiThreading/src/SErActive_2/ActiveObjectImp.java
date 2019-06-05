package SErActive_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import SErActive.Result;

public class ActiveObjectImp implements ActiveObject{
	private final ExecutorService service=Executors.newSingleThreadExecutor();
	
	public Future<String> MakingString(int count, char fillchar) {
		class MakingStringRequest implements Callable<String>{
			public String call() throws Exception {
				char buffer[]=new char[count];
				for(int i=0;i<count;i++)
					buffer[i]=fillchar;
				String str=new String(buffer);
				return str;
			}
		}
		
		return service.submit(new MakingStringRequest());
	}

	public void DisplayString(String string) {
		class DisplayStringRequest implements Runnable{
			public void run() {
				System.out.println(string);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {}
			}
		}
		
		service.execute(new DisplayStringRequest());
	}

	public Future<String> Add(String x, String y) {
		class AddRequest implements Callable<String>{
			public String call() throws Exception {
				return String.valueOf(Integer.parseInt(x)+Integer.parseInt(y));
			}
		}
		return service.submit(new AddRequest());
	}
	
	public void shutdown() {
		service.shutdown();
	}

}
