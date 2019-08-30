package ch1;

public class Test {
	public static void main(String[] args) {
		TomProxy proxy=new TomProxy(new Tom());
		proxy.eat("apple");
	}
}
