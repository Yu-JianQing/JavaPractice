package 工厂方法;

public class IdCard extends Product{
	private String owner;
	
	public IdCard(String owner) {
		this.owner=owner;
		System.out.println("start "+owner+" card");
	}
	
	@Override
	public void use() {
		System.out.println("test "+owner+" card");
	}
	
	public String getOwner(){
		return owner;
	}

}
