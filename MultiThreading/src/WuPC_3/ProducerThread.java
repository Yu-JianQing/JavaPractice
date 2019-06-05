package WuPC_3;

import java.util.concurrent.Exchanger;

public class ProducerThread extends Thread{
	private final Exchanger<char[]> exchanger;
	private char [] buffer;
	private char index=0;//用于生产26个字母
	
	public ProducerThread(String name,Exchanger<char[]> exchanger,char [] buffer){
		super(name);
		this.exchanger=exchanger;
		this.buffer=buffer;
	}
	
	private char nextChar() throws InterruptedException{
		char c=(char) ('A'+index%26);
		index++;
		Thread.sleep(1000);
		return c;
	}
	
	public void run(){
		try {
			while(true){
				for(int i=0;i<buffer.length;i++){
					buffer[i]=this.nextChar();
					System.out.print(buffer[i]);
				}
				System.out.println();
				System.out.println(Thread.currentThread().getName()+"before exchange");
				buffer=exchanger.exchange(buffer);
				System.out.println(Thread.currentThread().getName()+"after exchange");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
