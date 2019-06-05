package ErImmu_2;

import java.util.List;

public class ReadThread extends Thread{
	private final List<Integer> list;
	
	public ReadThread(List<Integer> list){
		this.list=list;
	}
	
	public void run(){
		while(true){
			synchronized(list){
				for(int i:list){
					System.out.println("read"+i);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
	}
}
