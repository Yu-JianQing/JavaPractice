package AdapterÊÊÅäÆ÷;

public class PrintBanner extends Banner implements Print{

	public PrintBanner(String str) {
		super(str);
	}

	@Override
	public void print1() {
		super.show1();
	}

	@Override
	public void print2() {
		super.show2();
	}

}
