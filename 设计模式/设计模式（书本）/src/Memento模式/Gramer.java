package Mementoģʽ;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gramer {
	private int money;
	private List<String> fruits=new ArrayList<String>();
	private Random random=new Random();
	private static String fruitsName[]={"--A--","--B--","--C--","--D--"};
	
	public Gramer(int money){
		this.money=money;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public Memento createMemento(){
		Memento memento=new Memento(money);
		for(String fruit:fruits){
			if(fruit.startsWith("good"))
				memento.addFruit(fruit);
		}
		return memento;
	}
	
	public void restoreMemento(Memento memento){
		this.money=memento.money;
		this.fruits=memento.getFruits();
	}
	
	private String getFruit(){
		String prefix="";
		if(random.nextBoolean())
			prefix="good";
		return prefix+fruitsName[random.nextInt(fruitsName.length)];
	}
	
	public void bet(){
		int r=random.nextInt(6)+1;
		if(r==1){
			money=money+100;
			System.out.println("money increment +++");
		}else if(r==2){
			money=money/2;
			System.out.println("money decrement ---");
		}else if(r==6){
			String f=getFruit();
			fruits.add(f);
			System.out.println("get a fruit "+f);
		}else {
			System.out.println("nothing......");
		}
	}

	@Override
	public String toString() {
		return "Gramer [money=" + money + ", fruits=" + fruits + "]";
	}
	
}
