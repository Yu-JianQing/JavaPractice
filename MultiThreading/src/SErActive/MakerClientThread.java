package SErActive;

public class MakerClientThread extends Thread{
	private final ActiveObject activeObject;
	private final char fillchar;
	
	public MakerClientThread(ActiveObject activeObject,String name){
		super(name);
		this.activeObject=activeObject;
		this.fillchar=name.charAt(0);
	}
	
	public void run(){
		try {
			for (int i = 0;  true; i++) {
				Result<String> result=activeObject.makeString(i, fillchar);
				Thread.sleep(50);
				String value=result.getResultValue();
				System.out.println(Thread.currentThread().getName()+": value="+value);
			}
		} catch (InterruptedException e) {}
	}
}
