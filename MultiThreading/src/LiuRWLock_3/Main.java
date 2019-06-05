package LiuRWLock_3;

public class Main {
	public static void main(String[] args) {
		Database<String, String> database=new Database<String, String>();
		new AssignThread(database, "A", "a1").start();
		new AssignThread(database, "A", "aaaa2").start();
		new AssignThread(database, "B", "b1").start();
		new AssignThread(database, "B", "bbbb2").start();
		
		for (int i = 0; i < 100; i++) {
			new RetrieveThread(database, "A").start();
			new RetrieveThread(database, "B").start();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}
		
		System.exit(0);
	}
}
