package QiTPM_3;

public class Helper {
	public synchronized void hander(){
		System.out.println("service begin");
		for (int i = 0; i < 50; i++) {
			System.out.print("6");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		System.out.println();
		System.out.println("service done");
	}
}
