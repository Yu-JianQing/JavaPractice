package XuOne;

public class Test3 {
public static void main(String[] args) {
	for(int i=0;i<10;i++){
		System.out.print("1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
