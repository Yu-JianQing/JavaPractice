package YiSTE_2;

public class Main {
	public static void main(String[] args) {
		Tool spoon=new Tool("spoon");
		Tool fork=new Tool("fork");
		new EaterThread("Tom", spoon, fork).start();
		new EaterThread("Jerry", spoon, fork).start();
	}
}
