package num6;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Person person=new Proxy(new Tom());
		
		List<String> list=person.Hobbits("x", "y");
		
		for(String s:list){
			System.out.println(s);
		}
		
		
	}
}
