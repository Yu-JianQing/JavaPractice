package SiBalking_3;

public class TestThread extends Thread{
	public void run(){
		System.out.print("begin");
		for(int i=0;i<50;i++){
			System.out.print(".");
		}
		System.out.println("end");
	}
}
