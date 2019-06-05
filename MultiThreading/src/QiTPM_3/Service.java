package QiTPM_3;

public class Service {//一个接一个的全部依次完成
	private static final Helper helper=new Helper();
	
	public static void service(){
		new Thread(){
			public void run(){
				helper.hander();
			}
		}.start();
	}
}
