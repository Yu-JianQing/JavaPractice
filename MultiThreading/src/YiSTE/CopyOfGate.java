package YiSTE;

public class CopyOfGate {
	private int count=0;
	private String Pname="Nobody";
	private String Paddress="Nowhere";
	
	public synchronized  void pass(String Pname,String Paddress){
		this.count++;
		this.Pname=Pname;
		this.Paddress=Paddress;
		if(this.Pname.charAt(0)!=this.Paddress.charAt(0)){//加了this才能确保取到的值是当前线程的值
			System.out.println("*******broken********"+toString());}
	}
	
	public synchronized String toString(){
		return "No."+count+":"+Pname+","+Paddress;
	}
}
