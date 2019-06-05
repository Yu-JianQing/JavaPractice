package YiSTE;

import java.util.Random;

public class User_2 extends Thread {
	private final static Random RANDOM=new Random(10000);
	private final BoundedResource_2 resource;
	
	public User_2(BoundedResource_2 resource){
		this.resource=resource;
	}
	
	public void run(){
		while(true){
			try {
				resource.use();
				Thread.sleep(RANDOM.nextInt(3000));
			} catch (Exception e) {
				System.out.println("user error");
			}
		}
	}
	
}