package SYiTSS;

public class ClientThread extends Thread{
//	private final Log log=new Log();
	public ClientThread(String name){
		super(name);
	}
	
	public void run(){
		System.out.println(getName()+"  begin");
		for (int i = 0; i < 10; i++) {
			Log.println(" i="+i);
//			log.println(" i="+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		Log.close();
		System.out.println(getName()+"  end");
	}
}
