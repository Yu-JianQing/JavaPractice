package QiTPM_3;

public class Service {//һ����һ����ȫ���������
	private static final Helper helper=new Helper();
	
	public static void service(){
		new Thread(){
			public void run(){
				helper.hander();
			}
		}.start();
	}
}
