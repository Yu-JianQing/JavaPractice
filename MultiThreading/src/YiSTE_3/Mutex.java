package YiSTE_3;

public final class Mutex {
	private boolean busy=false;//标志字表示资源是否有人在用
	
	public synchronized void lock(){//加锁，不让进
		while(busy){//如果资源没人用接14行。如果有人用
			try {
				wait();//一直等待资源释放
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		busy=true;//我用
	}
	
	public synchronized void unlock(){//解锁，让进
		busy=false;//资源没人用了
		notifyAll();//叫醒所有线程
	}
}
//问题：1.当一个线程两次调用lock则第二次不能进入相当于自己把自己锁在外面
//2.任意线程都可调用unlock则不是自己上的锁也能打开