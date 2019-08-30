package ch4;

public class Test {
	public static void main(String[] args) {
		ProxyFactory factory=new ProxyFactory(new AddImpl());
		Add add=(Add) factory.getProxy();
		add.add(5, 6);
	}
}
