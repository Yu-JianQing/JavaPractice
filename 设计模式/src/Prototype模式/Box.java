package Prototypeģʽ;

public class Box implements Product{

	@Override
	public void use(String str) {
		System.out.println("use box "+str);
	}

	@Override
	public Product createProductByClone() {
		Product p=null;
		try {
			p=(Product) clone();
		} catch(CloneNotSupportedException e){
			System.out.println(e);
		}
		return p;
	}

}
