package XuOne;

public class Test2_3 implements Runnable{
	private String msg;
	public  Test2_3(String msg) {
		this.msg=msg;
	}
	@Override
	public void run() {
		for(int i=0;i<50;i++)
			System.out.print(msg);
	}

}
