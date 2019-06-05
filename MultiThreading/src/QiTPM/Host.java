package QiTPM;

public class Host {
	private final Helper helper=new Helper();
//	private Helper helper;
	
	public void requst(int count,char c){
		System.out.println("request"+"显示"+c+count+"次 begin");
		new Thread(){
			public void run(){
//				helper=new Helper();
				helper.display(count, c);
			}
		}.start();
		System.out.println("request"+"显示"+c+count+"次 end");
	}
}
