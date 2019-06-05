package WuPC_4;

public class Main {
	public static void main(String[] args) {
		Thread exetor=new Thread(new Runnable() {
			public void run() {
				System.out.println("exe begin");
				try {
					Host.execute(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("exe end");
			}
		});
		
		exetor.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println("*********interrupt*************");
		exetor.interrupt();
	}
}
