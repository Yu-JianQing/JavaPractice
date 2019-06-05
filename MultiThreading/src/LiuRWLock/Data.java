package LiuRWLock;

public class Data {
	private final char[] buffer;
//	private final ReadWriteLock rwLock=new ReadWriteLock();
	private final ReadWriteLock_S rwLock=new ReadWriteLock_S();
	
	public Data(int size){
		buffer=new char[size];
		for(int i=0;i<buffer.length;i++)
			buffer[i]='*';
	}
	
	private char[] doRead(){
		char newBuffer[]=new char[buffer.length];
		for(int i=0;i<buffer.length;i++)
			newBuffer[i]=buffer[i];
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		return newBuffer;
	}
	
	private void doWrite(char c){
		for(int i=0;i<buffer.length;i++)
			buffer[i]=c;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
	}
	
	public char[] read() throws InterruptedException{
		rwLock.readLock();
		try {
			return doRead();
		}finally{
			rwLock.readUnLock();
		}
	}
	
	public void write(char c) throws InterruptedException{
		rwLock.writeLock();
		try{
			doWrite(c);
		}finally{
			rwLock.writeUnLock();
		}
	}
}
