package в╟йндёй╫;

public class UpDownBorder extends Border{

	protected UpDownBorder(Display display) {
		super(display);
	}

	@Override
	public int getRows() {
		return 2+display.getRows();
	}

	@Override
	public int getNumPerRow() {
		return display.getNumPerRow();
	}

	@Override
	public String getText(int rows) {
		if(rows==0||rows==display.getRows()+1)
			return makeLine('*', display.getNumPerRow());
		else
			return display.getText(rows-1);
	}
	
	public String makeLine(char c,int count){
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<count;i++)
			buffer.append(c);
		return buffer.toString();
	}

}
