package ���󹤳�;

public class NSmallBox extends SmallBox{

	public NSmallBox(String ItemName) {
		super(ItemName);
	}

	@Override
	public String makeProduct() {
		return "n small box :"+ItemName;
	}

}
