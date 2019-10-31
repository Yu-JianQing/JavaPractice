package ³éÏó¹¤³§;

public class NScrew extends Screw{

	public NScrew(String ItemName, String type) {
		super(ItemName, type);
	}

	@Override
	public String makeProduct() {
		return "n screw: "+ ItemName+ " : " +type;
	}

}
