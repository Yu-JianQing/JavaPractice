package WuPC;

public class Table {
	private final String [] capacity;
	private int count=0;
	private int tail=0;
	private int head=0;
	
	public Table(int max){
		capacity=new String[max];
	}
	
	public synchronized void put(String cake) throws InterruptedException{
		while(count>=capacity.length){
			wait();
		}
		capacity[tail]=cake;
		tail=(tail+1)%capacity.length;
		count++;
		System.out.println(Thread.currentThread().getName()+"     put a     "+cake);
		notifyAll();
	}
	
	public synchronized void eat() throws InterruptedException{
		while(count<=0){
			wait();
		}
		String cake=capacity[head];
		head=(head+1)%capacity.length;
		count--;
		System.out.println(Thread.currentThread().getName()+"     eat a     "+cake);
		notifyAll();
	}
	
	public synchronized void clear(){
		//清除的是哪些蛋糕
		while(count>0){
			System.out.println("还有"+count+"个蛋糕"+capacity[head]);
			head=(head+1)%capacity.length;
			count--;
		}
		this.count=0;
		this.tail=0;
		this.head=0;
		notifyAll();
	}
}
