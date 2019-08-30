package ch4;

public class Tom implements Person{

	@Override
	public String eat(String name) {
		System.out.println("eating "+name);
		return name;
	}

}
