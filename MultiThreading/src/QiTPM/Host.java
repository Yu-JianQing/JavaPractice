package QiTPM;

public class Host {
	private final Helper helper=new Helper();
//	private Helper helper;
	
	public void requst(int count,char c){
		System.out.println("request"+"��ʾ"+c+count+"�� begin");
		new Thread(){
			public void run(){
//				helper=new Helper();
				helper.display(count, c);
			}
		}.start();
		System.out.println("request"+"��ʾ"+c+count+"�� end");
	}
}
