package ShiTPT_2;

public class Main {
	public static void main(String[] args) {
		System.out.println("main begin");
		
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			public void uncaughtException(Thread t, Throwable e) {
					System.out.println("*******´¦ÀíÆ÷*********");
					System.out.println("UncaughtExceptionHandler begin");
					System.out.println("current thread :"+Thread.currentThread());
					System.out.println("thread :"+t);
					System.out.println("exception :"+e);
					System.out.println("UncaughtExceptionHandler end");
			}
		});
		
		Runtime.getRuntime().addShutdownHook(
				new Thread(){
					public void run(){
						System.out.println("*******¹³×Ó*******");
						System.out.println("shut down hook begin");
						System.out.println("current thread :"+Thread.currentThread());
						System.out.println("shut down hook end");
					}
				}
		);
		
		new Thread("MyThread"){
			public void run(){
				System.out.println("My thread begin");
				System.out.println("my thread sleeping......");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {}
				System.out.println("my thread divide");
				
				int x=1/0;
				System.out.println("My thread begin");
			}
		}.start();
		
		System.out.println("main end");
	}
}
