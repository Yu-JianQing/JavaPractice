package LiuRWLock;

public class Main {
	public static void main(String[] args) {
		Data data=new Data(10);
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new ReaderThread(data).start();
		new WriterThread(data, "ABCDEFG").start();
		new WriterThread(data, "abcdefg").start();
	}
}
