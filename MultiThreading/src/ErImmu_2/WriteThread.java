package ErImmu_2;

import java.util.List;

public class WriteThread extends Thread{
	private final List<Integer> list;
	
	public WriteThread(List<Integer> list){
		this.list=list;
	}
	
	public void run(){
		for(int i=0;true;i++){
			list.add(i);
			System.out.println("write"+list.get(0));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			list.remove(0);
		}
	}
}
