package SErActive_2;

public class Main {
	public static void main(String[] args) {
		ActiveObject activeObject=ActiveObjectFactory.createActiveObject();
		
		try {
			new MakerClientThread(activeObject, "Tom").start();
			new MakerClientThread(activeObject, "Jerry").start();
			new DisplayClientThread(activeObject, "Bob").start();
			new AddClientThread(activeObject, "LiSa").start();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}finally{
			System.out.println("****shut down****");
			activeObject.shutdown();
		}
		
	}
}