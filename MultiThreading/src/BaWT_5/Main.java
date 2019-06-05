package BaWT_5;

public class Main {
	public static void main(String[] args) {
		Channel channel=new Channel(5);
		channel.startWorkers();
		ClientThread Tom=new ClientThread("Tom", channel);
		ClientThread Jerry=new ClientThread("Jerry", channel);
		ClientThread Bob=new ClientThread("Bob", channel);
		Tom.start();
		Jerry.start();
		Bob.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		Tom.stopThread();
		Jerry.stopThread();
		Bob.stopThread();
		channel.stopAllWorkers();
	}
}
