package SErActive;

public class FutureResult<T> extends Result<T>{
	private Result<T> result;
	private boolean ready=false;
	
	public synchronized void setResult(Result<T> result){
		this.result=result;
		this.ready=true;
		notifyAll();
	}
	
	public synchronized T getResultValue() {
		try {
			if(!ready)
				wait();
		} catch (InterruptedException e) {}
		return this.result.getResultValue();
	}

}
