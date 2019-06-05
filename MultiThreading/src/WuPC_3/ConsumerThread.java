package WuPC_3;

import java.util.concurrent.Exchanger;

public class ConsumerThread extends Thread{
	private final Exchanger<char[]> exchanger;
	private char[] buffer;
	
	public ConsumerThread(String name,Exchanger<char[]> exchanger,char[] buffer){
		super(name);
		this.exchanger=exchanger;
		this.buffer=buffer;
	}
	
	public void run(){
		try {
			while(true){
				System.out.println(Thread.currentThread().getName()+"before exchange"); 
				buffer=exchanger.exchange(buffer);
				System.out.println(Thread.currentThread().getName()+"after exchange"); 
				
				for(int i=0;i<buffer.length;i++)
						System.out.print(buffer[i]);
				System.out.println();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}