package YiSTE;

public class CopyOfGate {
	private int count=0;
	private String Pname="Nobody";
	private String Paddress="Nowhere";
	
	public synchronized  void pass(String Pname,String Paddress){
		this.count++;
		this.Pname=Pname;
		this.Paddress=Paddress;
		if(this.Pname.charAt(0)!=this.Paddress.charAt(0)){//����this����ȷ��ȡ����ֵ�ǵ�ǰ�̵߳�ֵ
			System.out.println("*******broken********"+toString());}
	}
	
	public synchronized String toString(){
		return "No."+count+":"+Pname+","+Paddress;
	}
}