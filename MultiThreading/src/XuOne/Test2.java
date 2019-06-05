package XuOne;

public class Test2 {
public static void main(String[] args) {
//	new Test2_2("0").start();
//	new Test2_2("1").start();
	new Thread(new Test2_3("0")).start();
	new Thread(new Test2_3("1")).start();
}
}
