package YiSTE_3;

public class Main {
public static void main(String[] args) {
	Gate gate=new Gate();
	new User(gate, "Alice", "Aust").start();
	new User(gate, "Bob", "Brazil").start();
	new User(gate, "Chris", "Canada").start();
}
}
