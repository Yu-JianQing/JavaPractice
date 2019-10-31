package Prototypeģʽ;

import java.util.HashMap;

public class Manger {
	private HashMap<String, Product> map=new HashMap<String, Product>();
	
	public Product createProduct(String name){
		Product p=map.get(name);
		return p.createProductByClone();
	}
	
	public void register(String name,Product product){
		map.put(name, product);
	}
	
}
