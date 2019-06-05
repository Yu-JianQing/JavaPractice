package YiSTE;

public class Main {
public static void main(String[] args) {
//	Gate gate=new Gate();
	CopyOfGate gate=new CopyOfGate();
	new User(gate, "Alice", "Aust").start();
	new User(gate, "Bob", "Brazil").start();
	new User(gate, "Chris", "Canada").start();
}
}
