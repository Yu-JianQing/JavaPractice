package WuPC;

public class MakerThread extends Thread{
//	private final Table table;
	private final Table_S table;
	private static int id=0;
	
//	public MakerThread(String name,Table table){
	public MakerThread(String name,Table_S table){
		super(name);
		this.table=table;
	}
	
	private static synchronized int getID(){
		return id++;
	}
	
	public void run(){
		try {
			while(true){
				table.put("cake "+getID());
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
	}
}
