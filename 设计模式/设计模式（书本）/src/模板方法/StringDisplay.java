package Ä£°å·½·¨;

public class StringDisplay extends AbstractDisplay{
	private String str;
	
	public StringDisplay(String str){
		this.str=str;
	}
	
	public void printLine(){
		System.out.print("+");
		for(int i=0;i<str.getBytes().length;i++)
			System.out.print("-");
		System.out.println("+");
	}

	@Override
	public void open() {
		printLine();
	}

	@Override
	public void print() {
		System.out.println("|"+str+"|");
	}

	@Override
	public void close() {
		printLine();
	}
	
	
	
}
