package YiSTE_2;

public class EaterThread_2 extends Thread{
	private final AllResoure_2 allResoure;
	private String personName;
	
	public EaterThread_2(String personName,AllResoure_2 allResoure) {
		this.allResoure=allResoure;
		this.personName=personName;
	}
	
	public void eat(){
		synchronized(this.allResoure){
			System.out.println(this.personName+"���������Դ");
			System.out.println(this.personName+"�Է�");
			System.out.println(this.personName+"�ͷ�������Դ");
		}
	}
	
	public void run(){
		while(true){
			eat();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
}
