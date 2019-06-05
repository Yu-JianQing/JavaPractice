package ErImmu;

public class Main {
	public static void main(String[] args) {
		Person person=new Person("Tom", "Amercia");
		new PrintPersonThread(person).start();
		Person person1=new Person("Jerry", "England");
		new PrintPersonThread(person1).start();
//		new PrintPersonThread(person).start();
	}
}
