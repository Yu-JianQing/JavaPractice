package SErActive;

public class DisplayClientThread extends Thread{
	private final ActiveObject activeObject;
	
	public DisplayClientThread(ActiveObject activeObject,String name){
		super(name);
		this.activeObject=activeObject;
	}
	
	public void run(){
		try {
			for (int i = 0; true; i++) {
				String string=Thread.currentThread().getName()+"  "+i;
				activeObject.displayString(string);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {}
	}
	
}
