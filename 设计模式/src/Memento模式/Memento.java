package Mementoģʽ;

import java.util.ArrayList;
import java.util.List;

public class Memento {
	int money;
	ArrayList<String> fruits=new ArrayList<String>();
	
	Memento(int money){
		this.money=money;
	}
	
	public int getMoney(){
		return money;
	}
	
	void addFruit(String fruit){
		fruits.add(fruit);
	}
	
	@SuppressWarnings("unchecked")
	List<String> getFruits(){
		return (List<String>) fruits.clone();
	}

}
