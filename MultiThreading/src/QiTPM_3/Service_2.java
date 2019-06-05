package QiTPM_3;

public class Service_2 {//只执行第一次
	static final Helper helper=new Helper();
	
	public static void service(){
		new ThreadHelper().start();
	}
	
	private static class Helper{
		private volatile boolean walking=false;
		
		public void hander(){
			if(walking==true){
				System.out.println("service is balked");
				return ;
			}
			System.out.println("service begin");
			walking=true;
			for (int i = 0; i < 50; i++) {
				System.out.print("6");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
			}
			System.out.println();
			System.out.println("service done");
			walking=false;
		}
	}
	
	private static class ThreadHelper extends Thread{
		public void run(){
			helper.hander();
		}
	}
}
