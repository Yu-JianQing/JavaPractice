package ch1;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest{
	private PrintStream print;
	
	public SlayDragonQuest(PrintStream print){
		this.print=print;
	}
	
	public void embark() {
		print.println("saly dragon");
	}

}
