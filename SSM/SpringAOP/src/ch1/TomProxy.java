package ch1;

public class TomProxy {
	private Tom tom;
	
	public TomProxy(Tom tom){
		this.tom=tom;
	}

	public Tom getTom() {
		return tom;
	}

	public void setTom(Tom tom) {
		this.tom = tom;
	}
	
	public void eat(String name){
		System.out.println("eat before");
		tom.eat(name);
		System.out.println("eat after");
	}
}
