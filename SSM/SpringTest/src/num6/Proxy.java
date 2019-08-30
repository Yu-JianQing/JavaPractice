package num6;

import java.util.List;

public class Proxy implements Person{
	private Tom tom;
	
	public Proxy(Tom tom){
		this.tom=tom;
	}
	
	public void setTom(Tom tom) {
		this.tom = tom;
	}

	@Override
	public List<String> Hobbits(String h1, String h2) {
		System.out.println("tom before");
		
		List<String> list=tom.Hobbits(h1, h2);
		
		System.out.println("tom after");
		return list;
	}

}
