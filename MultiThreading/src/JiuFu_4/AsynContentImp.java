package JiuFu_4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AsynContentImp extends FutureTask<SynContentImp> implements Content{
	public AsynContentImp(Callable<SynContentImp> callable) {
		super(callable);
	}
	
	public synchronized byte[] getBytes() {
		SynContentImp realContent=null;
		try {
			realContent = this.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return realContent.getBytes();
	}

}
