package LiuRWLock;
//��preferWrite����
public class ReadWriteLock_S_S {
	private boolean preferWrite=true;//�¼���ı���
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
		preferWrite=false;//д��֮�������Ȩ�ø�����
		notifyAll();
	}
	
	public synchronized void readLock() throws InterruptedException{
		while(writing>0||(preferWrite&&waitWrite>0))
			wait();
		reading++;
	}
	
	public synchronized void readUnLock() throws InterruptedException{
		reading--;
		preferWrite=true;//����֮�������Ȩ�ø�д��
		notifyAll();
	}
}
