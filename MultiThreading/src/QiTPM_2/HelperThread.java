package QiTPM_2;

public class HelperThread extends Thread{
	private final int count;
	private final char c;
	private final Helper helper=new Helper();
	
//	public HelperThread(Helper helper,int count,char c){//n���߳�1��helper���ܲ�����helper�൱�ڶ����ٽ���Դ
//		this.helper=helper;
//		this.count=count;
//		this.c=c;
//	}
	
	public HelperThread(int count,char c){//n���߳�n��helper����n���̲߳���
		this.count=count;
		this.c=c;
	}
	
	public void run(){
		helper.display(count, c);
	}
}
