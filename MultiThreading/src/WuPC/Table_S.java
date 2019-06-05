package WuPC;

import java.util.concurrent.ArrayBlockingQueue;

public class Table_S extends ArrayBlockingQueue<String>{
	public Table_S(int max){
		super(max);
	}
	
	public void put(String cake) throws InterruptedException{
		System.out.println(Thread.currentThread().getName()+"     put a     "+cake);
		super.put(cake);
	}
	
	public String take() throws InterruptedException{
		String cake=super.take();
		System.out.println(Thread.currentThread().getName()+"     eat a     "+cake);
		return cake;
	}
}
