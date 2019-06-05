package ShiTPT_7;

public class ServiceThread extends GracefulThread{
	
	public void doService() throws InterruptedException{
		System.out.println("service");
		for (int i = 0; i < 30; i++) {
			System.out.print(6);
			Thread.sleep(300);
		}
		shutdownRequest();
	};
	
	public void doShutdown(){
		System.out.println("done 6");
	};
	
}
