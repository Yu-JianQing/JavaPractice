package SErActive;

public class Main {
	public static void main(String[] args) {
		ActiveObject activeObject=ActiveObjectFactory.createActiveObject();
		new MakerClientThread(activeObject, "Tom").start();
		new MakerClientThread(activeObject, "Jerry").start();
		new DisplayClientThread(activeObject, "Bob").start();
		new AddClientThread(activeObject, "LiSa").start();
	}
}
