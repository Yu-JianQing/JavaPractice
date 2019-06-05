package ShiTPT_8;

public class HanoThread extends Thread{
	private volatile boolean shutdownRequest=false;
	private volatile long requestTime=0;
	
	public void shutdownRequest(){
		requestTime=System.currentTimeMillis();
		shutdownRequest=true;
		interrupt();
	}
	
	public boolean isShutdownRequested(){
		return shutdownRequest;
	}
	
	private void doShutdown(){
		long time=System.currentTimeMillis()-requestTime;
		System.out.println("do shut down time :"+time);
	}
	
	private void doWork(int level,char posA,char posB,char posC) throws InterruptedException{
		if(level>0){
			if(isShutdownRequested())
				throw new InterruptedException();
			doWork(level-1, posA, posC, posB);
			System.out.print(posA+"-->"+posB+"  ");
			doWork(level-1, posC, posB, posA);
		}
	}
	
	public void run(){
		try {
			for(int level=0;!isShutdownRequested();level++){
				System.out.println("=====level :"+level+"======");
				doWork(level, 'A', 'B', 'C');
				System.out.println(" ");
			}
		} catch (InterruptedException e) {
		}finally{
			doShutdown();
		}
	}
}
