package SanGS;

public class Main {
	public static void main(String[] args) {
		RequestQueue requestQueue=new RequestQueue();
//		RequestQueue_S requestQueue=new RequestQueue_S();
		new ClientThread("Tom", requestQueue, 31578646L).start();
		new ServerThread("Jerry", requestQueue, 51578646L).start();
	}
}
