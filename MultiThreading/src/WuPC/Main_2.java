package WuPC;

public class Main_2 {
	public static void main(String[] args) {
//		Table table=new Table(3);
		Table_S table=new Table_S(3);
		Thread[] threads={
		new MakerThread("Maker-1", table),
		new MakerThread("Maker-2", table),
		new MakerThread("Maker-3", table),
		new EaterThread("Eater-1", table),
		new EaterThread("Eater-2", table),
		new EaterThread("Eater-3", table),
		};
		
		for(Thread thread:threads){
			thread.start();
		}
		
		//3s stop
		try {
			Thread.sleep(3000);
			System.out.println("stop");
			for(Thread thread:threads){
				thread.interrupt();
			}
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
	}
}
