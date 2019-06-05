package ShiTPT_5;

public class GracefulThread extends Thread{
	private volatile boolean shutDownRequest=false;
	
	public final void shutdownRequest(){
		shutDownRequest=true;
		interrupt();
	}
	
	public final boolean isShutdownRequest(){
		return shutDownRequest;
	}
	
	protected void doWork() throws InterruptedException{}
	
	protected void doShutdown(){}
	
	public final void run(){
		try {
			while(!isShutdownRequest())
				doWork();
		} catch (InterruptedException e) {
		}finally{
			doShutdown();
		}
	}
}
