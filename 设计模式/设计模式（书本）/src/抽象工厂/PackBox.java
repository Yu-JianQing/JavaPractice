package ³éÏó¹¤³§;

import java.util.ArrayList;

public abstract class PackBox {
	protected String maker;
	protected String time;
	protected ArrayList<Item> items=new ArrayList<Item>();
	
	public PackBox(String maker,String time){
		this.maker=maker;
		this.time=time;
	}
	
	public void add(Item item){
		items.add(item);
	}
	
	public abstract String makeProduct();
	
	public void end(){
		this.makeProduct();
		System.out.println("---end---");
	}
	
	public void print(){
		for(Item item :items)
			System.out.println(item.ItemName );
	}
	
}
