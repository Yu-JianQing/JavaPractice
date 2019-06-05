package QiTPM_3;

public class Service_4 {//优先执行用户最后点击的，前面点击的将被取消
	private static Thread thread=null;
	
	public static void service(){
//		if(thread!=null&&thread.isAlive()){
//			thread.interrupt();
//			try {
//				thread.join();
//			} catch (InterruptedException e) {	}
//			thread=null;
//		}
		if(thread!=null){
			thread.interrupt();
			thread=null;
		}
		thread=new Thread(){
			public void run(){
				System.out.println(thread.toString());
				doService();
			}
		};
		thread.start();
	}
	
	private static void doService(){
		try {
			System.out.println("service begin");
			for (int i = 0; i < 50; i++) {
				System.out.print("6");
				Thread.sleep(100);
			}
			System.out.println();
			System.out.println("service done");
		} catch (InterruptedException e) {
			System.out.println("cancelled");//必须加这一句否则上面interrupt之后会相当于没用
		}
	}
}
