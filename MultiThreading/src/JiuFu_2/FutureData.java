package JiuFu_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureData extends FutureTask<RealData> implements Data{
	
	public FutureData(Callable<RealData> callable) {
		super(callable);
		// TODO Auto-generated constructor stub
	}
	
	public String getContent() {
		String str=null;
		try {
			str=this.get().getContent();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
