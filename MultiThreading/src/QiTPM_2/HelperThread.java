package QiTPM_2;

public class HelperThread extends Thread{
	private final int count;
	private final char c;
	private final Helper helper=new Helper();
	
//	public HelperThread(Helper helper,int count,char c){//n个线程1个helper不能并发，helper相当于读的临界资源
//		this.helper=helper;
//		this.count=count;
//		this.c=c;
//	}
	
	public HelperThread(int count,char c){//n个线程n个helper，可n个线程并发
		this.count=count;
		this.c=c;
	}
	
	public void run(){
		helper.display(count, c);
	}
}
