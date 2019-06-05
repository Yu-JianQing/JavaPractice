package SYiTSS_2;

public class Main {
	public static void main(String[] args) {
		new ClientThread("Tom").start();
		new ClientThread("Jerry").start();
		new ClientThread("Bob").start();
	}
}
