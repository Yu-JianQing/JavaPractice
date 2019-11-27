package в╟йндёй╫;

public class Main {
	public static void main(String[] args) {
		Display display1=new StringDisplay("i am tom");
		Display display2=new SideBorder(display1, '#');
		Display display3=new FullBorder(display2);
		Display displayx=new FullBorder(display3);
		Display displayz=new UpDownBorder(displayx);
		
		display1.showAll();
		System.out.println();
		display2.showAll();
		System.out.println();
		display3.showAll();
		System.out.println();
		displayx.showAll();
		System.out.println();
		displayz.showAll();
		System.out.println();
		
		Display display4=new SideBorder(
				new FullBorder(
						new SideBorder(
								new FullBorder(
										new StringDisplay("hello word")
										)
								, '*')
						)
				, '/');
		
		display4.showAll();
		
		//----------------------//
		
		MultiStringDisplay md=new MultiStringDisplay();
		md.add("hello");md.add("tom");md.add("jerry");
		md.showAll();
		System.out.println();
		
		Display display6=new SideBorder(md, '#');
		display6.showAll();
		System.out.println();
		
		Display display7=new FullBorder(display6);
		display7.showAll();
	}
}
