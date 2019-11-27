package AdapterÊÊÅäÆ÷2;

public class PrintBanner extends Print{

	private Banner banner;
	
	public PrintBanner(String str){
		banner=new Banner(str);
	}

	public void print1(){
		banner.show1();
	}
	
	public void print2(){
		banner.show2();
	}
	
}
