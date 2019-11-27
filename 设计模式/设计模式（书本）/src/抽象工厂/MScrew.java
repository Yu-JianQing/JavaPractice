package ³éÏó¹¤³§;

public class MScrew extends Screw{

	public MScrew(String ItemName, String type) {
		super(ItemName, type);
	}

	@Override
	public String makeProduct() {
		return "m screw: "+ ItemName+ " : " +type;
	}

}
