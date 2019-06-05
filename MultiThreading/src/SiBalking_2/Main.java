package SiBalking_2;

import java.util.concurrent.TimeoutException;

public class Main {
	public static void main(String[] args) {
		Host host=new Host(5000);
		try {
			System.out.println("execute begin");
			host.execute();
		} catch (TimeoutException e) {
			System.out.println(e);
		}catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
