package ShiTPT_8;

public class Main {
	public static void main(String[] args) {
		System.out.println("main begin");
		try {
			HanoThread t=new HanoThread();
			t.start();
			
			Thread.sleep(1000);
			
			System.out.println("main : shut down request");
			t.shutdownRequest();
			
			System.out.println("main : join");
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end");
	}
}
