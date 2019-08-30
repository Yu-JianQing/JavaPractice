package ch4_1;

public class Test {
	public static void main(String[] args) {
		ProxyFactory factory=new ProxyFactory(new Add());
		
		Add add=(Add)factory.getProxy();
		
		add.add(5, 6);
		
	}
}
