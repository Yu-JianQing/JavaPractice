package ch9x2;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ProServiceImp implements ProService{
	private static ArrayList<Product> list=new ArrayList<Product>();
	
	@Override
	public boolean save(Product product) {
		list.add(product);
		return true;
	}

	@Override
	public ArrayList<Product> getProducts() {
		return list;
	}

}
