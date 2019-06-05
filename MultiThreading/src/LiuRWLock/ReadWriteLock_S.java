package LiuRWLock;
//纯写优先
public class ReadWriteLock_S {
//	private boolean preferWrite=true;
	private int reading=0;
	private int writing=0;
	private int waitWrite=0;//新加入的变量
	
	public synchronized void writeLock() throws InterruptedException{
		waitWrite++;
		while(reading>0||writing>0)
			wait();
		waitWrite--;
		writing++;
	}
	
	public synchronized void writeUnLock() throws InterruptedException{
		writing--;
//		preferWrite=false;//这里是为了一个写完后便大概率让人看，防止连写，连写也可以在这只是为了好看
		notifyAll();
	}
	
	public synchronized void readLock() throws InterruptedException{
//		while(writing>0||(preferWrite&&waitWrite>0))
		while(writing>0||waitWrite>0)
			wait();
		reading++;
	}
	
	public synchronized void readUnLock() throws InterruptedException{
		reading--;
//		preferWrite=true;
		notifyAll();
	}
}
