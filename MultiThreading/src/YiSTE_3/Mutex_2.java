package YiSTE_3;

public final class Mutex_2 {
	private int locks;//锁的数量，一个线程可以上多个锁
	private Thread owner;//当前线程
	
	public synchronized void lock(){
		Thread me=Thread.currentThread();
		while(locks>0&&owner!=me){//有锁并且不是我的
			try {
				wait();//被锁在外面等待
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		assert locks==0||owner==me;//while一旦退出意味着要么没锁了或者当前锁匙我自己的
		owner=me;//我上锁
		locks++;//锁的数量加1
	}
	
	public synchronized void unlock(){
		Thread me=Thread.currentThread();
		if(owner!=me||locks==0){//解锁时，当前锁不是我的或者没有锁
			return ;//不能解锁
		}
		assert owner==me&&locks>0;//if不满足也就是说有锁并且这把锁是我的
		locks--;//自己解锁
		if(locks==0){//当自己结完锁，看看还有锁么，没有的话
			owner=null;//拥锁人为空
			notifyAll();//叫醒所有线程
		}
	}
}
