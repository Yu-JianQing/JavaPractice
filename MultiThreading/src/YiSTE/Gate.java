package YiSTE;

public class Gate {
	private int count=0;
	private String Pname="Nobody";
	private String Paddress="Nowhere";
	
	public synchronized  void pass(String Pname,String Paddress){
		this.count++;
		this.Pname=Pname;
		this.Paddress=Paddress;
		check();
	}
	
	public synchronized  String toString(){
		return "No."+this.count+":"+this.Pname+","+this.Paddress;
	}
	
	private synchronized  void check(){//����������private����ȡ����ֵһ���Ǳ��̵߳�ֵ
		if(Pname.charAt(0)!=Paddress.charAt(0))
			System.out.println("*******broken********"+toString());
	}
}