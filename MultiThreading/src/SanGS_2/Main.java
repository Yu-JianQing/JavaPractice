package SanGS_2;

public class Main {
	public static void main(String[] args) {
		RequestQueue requestQueue=new RequestQueue();
		Thread Tom=new ClientThread("Tom", requestQueue, 31578646L);
		Thread Jerry=new ServerThread("Jerry", requestQueue, 51578646L);
		Tom.start();
		Jerry.start();
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("*********interrupt********");
		Tom.interrupt();
		Jerry.interrupt();
	}
}
