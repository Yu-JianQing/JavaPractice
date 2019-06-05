package LiuRWLock_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {
	private final char[] buffer;
	private final ReadWriteLock rwLock=new ReentrantReadWriteLock();//相当于带preferWrite的锁
	private final Lock readLock=rwLock.readLock();
	private final Lock writeLock=rwLock.writeLock();
	
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
		readLock.lock();
		try {
			return doRead();
		}finally{
			readLock.unlock();
		}
	}
	
	public void write(char c) throws InterruptedException{
		writeLock.lock();
		try{
			doWrite(c);
		}finally{
			writeLock.unlock();
		}
	}
}
