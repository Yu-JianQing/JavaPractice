package ³éÏó¹¤³§;

public class MSmallBox extends SmallBox{

	public MSmallBox(String ItemName) {
		super(ItemName);
	}

	@Override
	public String makeProduct() {
		return "m small box :"+ItemName;
	}

}
