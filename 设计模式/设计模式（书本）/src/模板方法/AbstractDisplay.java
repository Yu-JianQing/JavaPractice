package Ä£°å·½·¨;

public abstract class AbstractDisplay {
	public abstract void open();
	public abstract void print();
	public abstract void close();
	public final void diplay(){
		open();
		for(int i=0;i<5;i++)
			print();
		close();
	}
}
