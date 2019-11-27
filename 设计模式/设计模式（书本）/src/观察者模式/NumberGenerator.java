package 观察者模式;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	private ArrayList<Observer> observers=new ArrayList<Observer>();
	
	public abstract int getNumber();
	
	public abstract void execute();
	
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	
	public void deleteObserver(Observer observer){
		observers.remove(observer);
	}
	
	public void observerWork(){
		Iterator<Observer> iterator=observers.iterator();
		while(iterator.hasNext()){
			Observer obs=iterator.next();
			obs.update(this);
		}
	}

}
