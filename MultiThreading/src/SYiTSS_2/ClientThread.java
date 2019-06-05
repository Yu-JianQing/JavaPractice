package SYiTSS_2;

public class ClientThread extends Thread{
	public ClientThread(String name){
		super(name);
	}
	
	public void run(){
		System.out.println(getName()+"  begin");
		for (int i = 0; i < 10; i++) {
			Log.println(" i="+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
//		Log.close();不显示关闭，启动一个线程监视，做完自动关闭
		System.out.println(getName()+"  end");
	}
}
