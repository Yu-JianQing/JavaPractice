package WuPC;

public class EaterThread extends Thread{
//	private final Table table;
	private final Table_S table;
	
//	public EaterThread(String name,Table table){
	public EaterThread(String name,Table_S table){
		super(name);
		this.table=table;
	}
	
	public void run(){
		try {
			while(true){
//				table.eat();
				table.take();
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
	}
}
