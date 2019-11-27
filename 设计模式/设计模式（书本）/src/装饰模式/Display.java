package в╟йндёй╫;

public abstract class Display {
	public abstract int getRows();
	public abstract int getNumPerRow();
	
	public abstract String getText(int rows);
	
	
	public final void showAll(){
		int rows=getRows();
		for(int i=0;i<rows;i++)
			System.out.println(getText(i));
	}
	
}
