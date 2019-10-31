package Brigeģʽ;

public class StringDisplay extends AbstractDisplay {
	private String str;

	public StringDisplay(String str){
		this.str=str;
	}
	
	@Override
	public void beforeDisplay() {
		System.out.println("before  "+str);
	}

	@Override
	public void goingDisplay() {
		System.out.println("going  "+str);
	}

	@Override
	public void afterDisplay() {
		System.out.println("after  "+str);
	}

}
