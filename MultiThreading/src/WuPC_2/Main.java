package WuPC_2;

import java.util.concurrent.SynchronousQueue;

public class Main {
	public static void main(String[] args) {
		SynchronousQueue<String> queue=new SynchronousQueue<String>();
		new MakerThread("Maker1",queue).start();
		new MakerThread("Maker2",queue).start();
		new MakerThread("Maker3",queue).start();
		new EaterThread("Eater1", queue).start();
		new EaterThread("Eater2", queue).start();
		new EaterThread("Eater3", queue).start();
	}
}
