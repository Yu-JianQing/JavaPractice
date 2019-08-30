package ch6;

public class Orders {
	private int id;
	private String order;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", " + ", order=" + order + "]";
	}
}
