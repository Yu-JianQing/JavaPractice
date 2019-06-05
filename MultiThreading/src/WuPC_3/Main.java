package WuPC_3;

import java.util.concurrent.Exchanger;

public class Main {
	public static void main(String[] args) {
		Exchanger<char[]> exchanger=new Exchanger<char[]>();
		char[] buffer1=new char[10];
		char[] buffer2=new char[10];
		new ProducerThread("Producer", exchanger, buffer1).start();
		new ConsumerThread("Consumer", exchanger, buffer2).start();
	}
}
