package SErActive_3;

public class FutureResult extends Result<String>{
	private Result<String> result;
	private boolean ready=false;
	
	public synchronized String getValue() {
		if(!ready){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		return this.result.getValue();
	}

	public synchronized void set(Result<String> result){
		this.result=result;
		this.ready=true;
		notifyAll();
	}
}
