package QiTPM_5;

public class Blackhole2 {
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
				synchronized (obj) {//拿obj的锁
					synchronized (this) {//因为还要输出step2所以要唤醒主线程
						this.notifyAll();//唤醒也要先有相应对象的锁
					}
					try {
						this.join();//拿着obj的锁不放
					} catch (InterruptedException e) {}
				}
			}
		};
		thread.start();
		synchronized (thread) {
			try {//为保证新线程能拿到锁所以先将主线程堵塞
				thread.wait();//这句是将主线程堵塞在thread对象的对列中，wait时要先获得相应对象的锁，所以前面加了synchronize（thread）
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
