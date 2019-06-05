package ShiTPT;

public class Main {
	public static void main(String[] args) {
		System.out.println("main begin");
		try {
			CountupThread countup=new CountupThread();
			countup.start();
			
			Thread.sleep(5000);
			
			System.out.println("main shutdown request");
			countup.shutdownRequest();
			System.out.println("main wait die");
			
			countup.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end");
	}
}
