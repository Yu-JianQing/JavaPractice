package LiuRWLock;
//带preferWrite的锁
public class ReadWriteLock_S_S {
	private boolean preferWrite=true;//新加入的变量
	private int reading=0;
	private int writing=0;
	private int waitWrite=0;
	
	public synchronized void writeLock() throws InterruptedException{
		waitWrite++;
		try {
			while(reading>0||writing>0)
				wait();
		} finally {
			waitWrite--;
		}
		writing++;
	}
	
	public synchronized void writeUnLock() throws InterruptedException{
		writing--;
		preferWrite=false;//写完之后把优先权让给读者
		notifyAll();
	}
	
	public synchronized void readLock() throws InterruptedException{
		while(writing>0||(preferWrite&&waitWrite>0))
			wait();
		reading++;
	}
	
	public synchronized void readUnLock() throws InterruptedException{
		reading--;
		preferWrite=true;//读完之后把优先权让给写者
		notifyAll();
	}
}
