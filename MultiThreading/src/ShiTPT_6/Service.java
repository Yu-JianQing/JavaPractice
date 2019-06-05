package ShiTPT_6;

public class Service {
	
	public static void service(){
		new ServiceThread().start();
	}
	
	public static void cancel(){
		ServiceThread.setTerminate(true);
	}
}
