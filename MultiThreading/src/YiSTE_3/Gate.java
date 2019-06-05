package YiSTE_3;

public class Gate {
	private int count=0;
	private String Pname="Nobody";
	private String Paddress="Nowhere";
//	private Mutex mutex=new Mutex();
//	private Mutex_2 mutex=new Mutex_2();
	private Mutex_3 mutex=new Mutex_3();
	
	public  void pass(String Pname,String Paddress){
		mutex.lock();
		this.count++;
		this.Pname=Pname;
		this.Paddress=Paddress;
		check();
		mutex.unlock();
	}
	
	public  String toString(){
		return "No."+this.count+":"+this.Pname+","+this.Paddress;
	}
	
	private  void check(){
		if(Pname.charAt(0)!=Paddress.charAt(0))
			System.out.println("*******broken********"+toString());
	}
}
