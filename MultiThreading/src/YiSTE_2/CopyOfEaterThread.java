package YiSTE_2;

public class CopyOfEaterThread extends Thread{
	private final CopyOfTool leftHand;
	private final CopyOfTool rightHand;
	private String personName;
	
	public CopyOfEaterThread(String personName,CopyOfTool leftHand,CopyOfTool rightHand) {
		this.leftHand=leftHand;
		this.rightHand=rightHand;
		this.personName=personName;
	}
	
	public  void eat(){
		synchronized(leftHand){//���Ǿ�����Դ
			System.out.println(this.personName+"����"+this.leftHand);
			synchronized (rightHand) {//���Ǿ�����Դ
				System.out.println(this.personName+"����"+this.rightHand);
				System.out.println(this.personName+"�Է�");
				System.out.println(this.personName+"����"+this.rightHand);
			}
			System.out.println(this.personName+"����"+this.leftHand);
		}		
	}
	
	public void run(){
		while(true){
			this.eat();
		}
	}
	
}