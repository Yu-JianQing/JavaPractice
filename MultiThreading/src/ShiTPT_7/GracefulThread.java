package ShiTPT_7;

public class GracefulThread extends Thread{
	private volatile boolean terminate=false;
	
	public void shutdownRequest(){
		terminate=true;
		interrupt();
	}
	
	public void run(){
		try {
			while(terminate==false){
				doService();
			}
		} catch (InterruptedException e) {
		}finally{
			doShutdown();
		}
	}
	
	public void doService() throws InterruptedException{};
	
	public void doShutdown(){};
}
