package ³éÏó¹¤³§;

public abstract class Item {
	protected String ItemName;
	
	public Item(String ItemName){
		this.ItemName=ItemName;
	}
	
	public abstract String makeProduct();
	
}
