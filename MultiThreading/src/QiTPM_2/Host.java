package QiTPM_2;

public class Host {
//	private final Helper helper=new Helper();
	
	public void requst(int count,char c){
		System.out.println("request"+"��ʾ"+c+count+"�� begin");
//		new HelperThread(helper, count, c).start();
		new HelperThread(count, c).start();
		System.out.println("request"+"��ʾ"+c+count+"�� end");
	}
}
