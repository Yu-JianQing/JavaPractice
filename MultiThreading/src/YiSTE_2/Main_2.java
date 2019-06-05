package YiSTE_2;

public class Main_2 {
	public static void main(String[] args) {
		Tool_2 spoon=new Tool_2("spoon");
		Tool_2 fork=new Tool_2("fork");
		AllResoure_2 allResoure=new AllResoure_2(spoon, fork);
		new EaterThread_2("Tom", allResoure).start();
		new EaterThread_2("Jerry", allResoure).start();
	}
}
