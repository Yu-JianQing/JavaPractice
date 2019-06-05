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
		synchronized(leftHand){//这是竞争资源
			System.out.println(this.personName+"拿起"+this.leftHand);
			synchronized (rightHand) {//这是竞争资源
				System.out.println(this.personName+"拿起"+this.rightHand);
				System.out.println(this.personName+"吃饭");
				System.out.println(this.personName+"放下"+this.rightHand);
			}
			System.out.println(this.personName+"放下"+this.leftHand);
		}		
	}
	
	public void run(){
		while(true){
			this.eat();
		}
	}
	
}
