package Brigeģʽ;

public class Main {
	public static void main(String[] args) {
		Display display1=new Display(new StringDisplay("hello"));
		Display display2=new CountDisplay(new StringDisplay("tom"));
		
		CountDisplay display3=new CountDisplay(new StringDisplay("jerry"));
		
		display1.display();
		System.out.println("------------");
		display2.display();
		System.out.println("------------");
		display3.display();
		System.out.println("------------");
		
		display3.multiDisplay(3);
		System.out.println("------------");
		
		RandomDisplay display4=new RandomDisplay(new StringDisplay("jack"));
		display4.randomDisplay(5);
		System.out.println("------------");
		
		CountDisplay display5=new CountDisplay(new FileDisplay("C:\\Users\\USER\\Desktop\\�ļ��ݴ�\\IO����\\File1.txt"));
		display5.multiDisplay(3);
		
	}
}
