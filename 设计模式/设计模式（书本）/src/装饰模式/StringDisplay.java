package в╟йндёй╫;

public class StringDisplay extends Display{
	private String content;
	
	public StringDisplay(String content){
		this.content=content;
	}

	@Override
	public int getRows() {
		return 1;
	}

	@Override
	public String getText(int rows) {
		if(rows==0)
			return content;
		return "";
	}

	@Override
	public int getNumPerRow() {
		return content.getBytes().length;
	}

}
