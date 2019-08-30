package ch5;

public class Test {
	public static void main(String[] args) {
		ProxyFactory factory=new ProxyFactory(new Person());
		Person proxy=(Person) factory.getProxy();
		proxy.eat("apple");
	}
}
