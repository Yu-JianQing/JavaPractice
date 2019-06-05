package LiuRWLock_2;

import java.util.Random;

public class WriterThread extends Thread{
	private final Data data;
	private final String filler;
	private int index=0;
	
	public WriterThread(Data data,String filler){
		this.data=data;
		this.filler=filler;
	}
	
	private char nextChar(){
		char c=filler.charAt(index);
		index++;
		if(index>=filler.length())
			index=0;
		return c;
	}
	
	public void run(){
		try {
			while(true){
				char c=nextChar();
				data.write(c);
				System.out.println("write   "+c);
				Thread.sleep(new Random().nextInt(3000));
			}
		} catch (InterruptedException e) {}
	}
}
