package ch4;

public class Test {
	public static void main(String[] args) {
		ProxyFactory factory=new ProxyFactory(new Tom());
		Person person=(Person) factory.getTarget();
		person.eat("apple");
	}
}
