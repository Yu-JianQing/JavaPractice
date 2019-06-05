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
	
//	public synchronized void eat(){//synchronize加在eat方法上锁住的是线程本身，用的是线程对象的锁，
//		//也就是说两个不同线程的锁是不一样的，Tom eat和Jerry eat毫无关系,相当于没加
//		synchronized(leftHand){//这是竞争资源
//			System.out.println(this.personName+"拿起"+this.leftHand);
//			synchronized (rightHand) {//这是竞争资源
//				System.out.println(this.personName+"拿起"+this.rightHand);
//				System.out.println(this.personName+"吃饭");
//				System.out.println(this.personName+"放下"+this.rightHand);
//			}
//			System.out.println(this.personName+"放下"+this.leftHand);
//		}		
//	}
	
	public  void eat(){
		synchronized(EaterThread.class){//因为勺子和叉子的限制，同一时刻只能有一个人吃，给整个线程加锁加类锁，使得只能有一个人吃饭
			System.out.println(this.personName+"拿起"+this.leftHand);
			System.out.println(this.personName+"拿起"+this.rightHand);
			System.out.println(this.personName+"吃饭");
			System.out.println(this.personName+"放下"+this.leftHand);
			System.out.println(this.personName+"放下"+this.rightHand);
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
