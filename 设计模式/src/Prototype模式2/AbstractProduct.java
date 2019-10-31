package Prototypeģʽ2;

public class AbstractProduct implements Product{

	@Override
	public void use(String str) {}

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
