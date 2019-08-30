package num8;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		ProxyFactory factory=new ProxyFactory(new Tom());
		Tom person=(Tom) factory.getProxy();
		
		List<String> list=person.Hobbits("x", "y");
		
		for(String s:list){
			System.out.println(s);
		}
		
		
	}
}
