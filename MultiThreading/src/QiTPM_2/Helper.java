package QiTPM_2;

public class Helper {
	private void slowly(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {}
	}
	
	public void display(int count,char c){
		System.out.println("display begin"+"��ʾ"+c+count+"��");
		for (int i = 0; i < count; i++) {
//			slowly();
			System.out.print(c);
		}
		System.out.println();
		System.out.println("display end"+"��ʾ"+c+count+"��");
	}
}
