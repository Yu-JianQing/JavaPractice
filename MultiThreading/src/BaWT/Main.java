package BaWT;

public class Main {
	public static void main(String[] args) {
		Channel channel=new Channel(5);
		channel.startWorkers();
		new ClientThread("Tom", channel).start();
		new ClientThread("Jerry", channel).start();
		new ClientThread("Bob", channel).start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}
		System.exit(0);
	}
}
