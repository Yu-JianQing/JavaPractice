package AdapterÊÊÅäÆ÷;

public class Banner {
	private String str;
	
	public Banner(String str){
		this.str=str;
	}
	
	public void show1(){
		System.out.println("("+str+")");
	}
	
	public void show2(){
		System.out.println("*"+str+"*");
	}
	
}
