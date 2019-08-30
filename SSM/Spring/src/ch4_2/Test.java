package ch4_2;

import ch4.MyPerson;
import ch4.Person;

public class Test {
	public static void main(String[] args) {
//		Person person=(Person) ProxyFactory.getProxy(new MyPerson());
		
		ProxyF proxyF=new ProxyF(new MyPerson());
		Person person=(Person)proxyF.getProxy();
		
		person.eat();
		
		person.sleep();
		
	}
}
