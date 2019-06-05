package LiuRWLock;
//��д����
public class ReadWriteLock_S {
//	private boolean preferWrite=true;
	private int reading=0;
	private int writing=0;
	private int waitWrite=0;//�¼���ı���
	
	public synchronized void writeLock() throws InterruptedException{
		waitWrite++;
		while(reading>0||writing>0)
			wait();
		waitWrite--;
		writing++;
	}
	
	public synchronized void writeUnLock() throws InterruptedException{
		writing--;
//		preferWrite=false;//������Ϊ��һ��д�����������˿�����ֹ��д����дҲ��������ֻ��Ϊ�˺ÿ�
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
