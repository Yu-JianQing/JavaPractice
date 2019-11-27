package ³éÏó¹¤³§;

import java.util.ArrayList;

public abstract class SmallBox extends Item{
	protected ArrayList<Item> items=new ArrayList<Item>();
	
	public SmallBox(String ItemName) {
		super(ItemName);
	}

	public void add(Item item){
		items.add(item);
	}
	
}
