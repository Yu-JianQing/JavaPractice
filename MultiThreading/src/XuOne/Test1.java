package XuOne;

public class Test1 {
	public static void main(String[] args) {
		MyThread myThread=new MyThread();
		myThread.start();
		for(int i=0;i<50;i++)
			System.out.print("1");
	}
}


class MyThread extends Thread{
	public void run(){
		for(int i=0;i<50;i++)
			System.out.print("0");
	}
}