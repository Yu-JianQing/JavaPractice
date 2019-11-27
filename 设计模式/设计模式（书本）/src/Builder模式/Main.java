package Builderģʽ;

public class Main {
	public static void main(String[] args) {
		TextBulider textBulider=new TextBulider();
		HtmlBuilder htmlBuilder=new HtmlBuilder();
		
		Dirctor dirctor1=new Dirctor(textBulider);
		Dirctor dirctor2=new Dirctor(htmlBuilder);
		
		dirctor1.construct();
		String str=textBulider.getRS();
		System.out.println(str);
		
		dirctor2.construct();
		
	}
}
