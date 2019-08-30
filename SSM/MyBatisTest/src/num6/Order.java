package num6;

import java.util.List;

public class Order {
	private int id;
	private int oid;
	private List<Product> products;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", oid=" + oid + ", products=" + products
				+ "]";
	}
	
	
}
