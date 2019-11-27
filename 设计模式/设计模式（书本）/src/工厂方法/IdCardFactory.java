package 工厂方法;

import java.util.ArrayList;
import java.util.List;

public class IdCardFactory extends Factory{
	private ArrayList<Product> list=new ArrayList<Product>();

	@Override
	public Product createProduct(String owner) {
		return new IdCard(owner);
	}

	@Override
	public void registProduct(Product product) {
		list.add(product);
	}
	
	public List<Product> getOwners(){
		return list;
	}

}
