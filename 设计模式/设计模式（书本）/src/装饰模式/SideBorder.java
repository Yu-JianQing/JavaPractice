package 装饰模式;

public class SideBorder extends Border{//全都是display.方法
	private char c;

	protected SideBorder(Display display,char c) {
		super(display);
		this.c=c;
	}

	@Override
	public int getRows() {
		return display.getRows();
	}

	@Override
	public int getNumPerRow() {
		return 2+display.getNumPerRow();
	}

	@Override
	public String getText(int rows) {
		return c+display.getText(rows)+c;
	}

}
