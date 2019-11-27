package Prototypeģʽ;

public class Pen implements Product{

	@Override
	public void use(String str) {
		System.out.println("use pen "+str);
	}

	@Override
	public Product createProductByClone() {
		Product p=null;
		try {
			p=(Product) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}

}
