package ��������;

public abstract class Factory {
	public abstract Product createProduct(String owner);
	public abstract void registProduct(Product product);
	
	public final Product create(String owner){
		Product product=createProduct(owner);
		registProduct(product);
		return product;
	}
}
