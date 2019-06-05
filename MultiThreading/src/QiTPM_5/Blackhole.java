package QiTPM_5;

public class Blackhole {
	public static void enter(Object obj){
		System.out.println("Step1");
		magic(obj);
		System.out.println("Step2");
		synchronized (obj) {
			System.out.println("Step3 never reached here");
		}
	}
	
	public static void magic(Object obj){
		Thread thread=new Thread(){
			public void run(){
				synchronized (obj) {
					System.out.println("拿到obj的锁");
					synchronized (this) {
						System.out.println("拿到thread的锁");
						this.notifyAll();
						System.out.println("notifyall");
					}
					try {
						this.join();
						System.out.println("join");
					} catch (InterruptedException e) {}
				}
			}
		};
		synchronized (thread) {
			thread.start();
			try {
				System.out.println("已经wait了");
				thread.wait();
			} catch (InterruptedException e) {}
		}
	}
}
