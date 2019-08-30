package ch4_4;

public class Test {
	public static void main(String[] args) {
		ProxyPerson proxy=new ProxyPerson();
		
		Person person=proxy.getProx();
		
		person.eat();
		person.sleep();
		
	}
}
