package LiuRWLock;
//╢©╤асеох
public class ReadWriteLock {
	private int reading=0;
	private int writing=0;
	
	public synchronized void writeLock() throws InterruptedException{
		while(reading>0||writing>0)
			wait();
		writing++;
	}
	
	public synchronized void writeUnLock() throws InterruptedException{
		writing--;
		notifyAll();
	}
	
	public synchronized void readLock() throws InterruptedException{
		while(writing>0)
			wait();
		reading++;
	}
	
	public synchronized void readUnLock() throws InterruptedException{
		reading--;
		notifyAll();
	}
}
