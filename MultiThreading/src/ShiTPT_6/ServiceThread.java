package ShiTPT_6;

public class ServiceThread extends Thread{
	private static volatile boolean terminate=false;
	
	public static void setTerminate(boolean flag){
		terminate=flag;
	}
	
	private void doService() throws InterruptedException{
		for (int i = 0; i < 30; i++) {
			if(terminate==false){
				System.out.print(6);
				Thread.sleep(300);
			}else{
				interrupt();
			}
		}
	}
	
	public void run(){
		try {
			System.out.println("service");
			doService();
		} catch (InterruptedException e) {
		}finally{
			System.out.println("done 6");
			terminate=false;
		}
	}
}
