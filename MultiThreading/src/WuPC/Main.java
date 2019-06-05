package WuPC;

public class Main {
	public static void main(String[] args) {
//		Table table=new Table(3);
		Table_S table=new Table_S(3);
		new MakerThread("Maker-1", table).start();
		new MakerThread("Maker-2", table).start();
		new MakerThread("Maker-3", table).start();
		new EaterThread("Eater-1", table).start();
		new EaterThread("Eater-2", table).start();
		new EaterThread("Eater-3", table).start();
	}
}
