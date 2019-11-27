package 装饰模式;

public class FullBorder extends Border{//全都是display.方法

	protected FullBorder(Display display) {
		super(display);
	}

	@Override
	public int getRows() {
		return display.getRows()+2;
	}

	@Override
	public int getNumPerRow() {
		return 2+display.getNumPerRow();
	}

	@Override
	public String getText(int rows) {
		if(rows==0||rows==display.getRows()+1)
			return "+"+makeLine('-',display.getNumPerRow())+"+";
		else 
			return "|"+display.getText(rows-1)+"|";//不要忘记display.getRows()只能为1
	}
	
	public String makeLine(char c,int count){
		StringBuffer buffer=new StringBuffer();
		for(int i=0;i<count;i++)
			buffer.append(c);
		return buffer.toString();
	}

}
