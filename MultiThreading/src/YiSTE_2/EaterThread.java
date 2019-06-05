package YiSTE_2;

public class EaterThread extends Thread{
	private final Tool leftHand;
	private final Tool rightHand;
	private String personName;
	
	public EaterThread(String personName,Tool leftHand,Tool rightHand) {
		this.leftHand=leftHand;
		this.rightHand=rightHand;
		this.personName=personName;
	}
	
//	public synchronized void eat(){//synchronize����eat��������ס�����̱߳����õ����̶߳��������
//		//Ҳ����˵������ͬ�̵߳����ǲ�һ���ģ�Tom eat��Jerry eat���޹�ϵ,�൱��û��
//		synchronized(leftHand){//���Ǿ�����Դ
//			System.out.println(this.personName+"����"+this.leftHand);
//			synchronized (rightHand) {//���Ǿ�����Դ
//				System.out.println(this.personName+"����"+this.rightHand);
//				System.out.println(this.personName+"�Է�");
//				System.out.println(this.personName+"����"+this.rightHand);
//			}
//			System.out.println(this.personName+"����"+this.leftHand);
//		}		
//	}
	
	public  void eat(){
		synchronized(EaterThread.class){//��Ϊ���ӺͲ��ӵ����ƣ�ͬһʱ��ֻ����һ���˳ԣ��������̼߳�����������ʹ��ֻ����һ���˳Է�
			System.out.println(this.personName+"����"+this.leftHand);
			System.out.println(this.personName+"����"+this.rightHand);
			System.out.println(this.personName+"�Է�");
			System.out.println(this.personName+"����"+this.leftHand);
			System.out.println(this.personName+"����"+this.rightHand);
		}
	}
	
	public void run(){
		while(true){
			this.eat();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
