package QiTPM_3;

public class Service_3 {//优先执行用户最后点击的
	static final Helper helper=new Helper();
	
	public static void service(){
		new ThreadHelper().start();
	}
	
	private static class Helper{
		public void hander(){
			System.out.println("service begin");
			for (int i = 0; i < 50; i++) {
				System.out.print("6");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
			}
			System.out.println();
			System.out.println("service done");
		}
	}
	
	private static class ThreadHelper extends Thread{
		public void run(){
			helper.hander();
		}
	}
}
