package YiSTE;

public class User extends Thread{
	private	 final String name;
	private final String address;
//	private final Gate gate;
	private final CopyOfGate gate;
	
//	public User(Gate gate,String name,String address) {
	public User(CopyOfGate gate,String name,String address) {
		this.name=name;
		this.address=address;
		this.gate=gate;
	}
	
	public void run(){
		System.out.println(name+"   begin");
		while(true){
			gate.pass(name, address);
		}
	}
}
