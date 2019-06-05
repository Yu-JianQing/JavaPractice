package XuOne;

public class Test2_2 extends Thread{
	private String msg;
	public  Test2_2(String msg) {
		this.msg=msg;
	}
	public void run(){
		for(int i=0;i<50;i++)
			System.out.print(msg);
	}
}
