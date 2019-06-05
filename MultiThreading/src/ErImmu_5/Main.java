package ErImmu_5;

public class Main {
	public static void main(String[] args) {
		MutablePerson person=new MutablePerson("Aa","Aa");
		new Check(person).start();
		new Check(person).start();
		new Check(person).start();
		for(int i=0;true;i++){
			person.setPerson(""+i, ""+i);
		}
	}
}
