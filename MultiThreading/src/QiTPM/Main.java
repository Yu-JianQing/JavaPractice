package QiTPM;

public class Main {
	public static void main(String[] args) {
		System.out.println("main begin");
		Host host=new Host();
		host.requst(10, 'A');
		host.requst(20, 'B');
		host.requst(30, 'C');
		System.out.println("main end");
	}
}
