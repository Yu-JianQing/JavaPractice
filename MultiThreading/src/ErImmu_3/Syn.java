package ErImmu_3;

public class Syn{
	private final String name="notSyn";
	
	public synchronized String toString(){
		return "["+name+"]";
	}
}