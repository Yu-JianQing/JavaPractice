package ³éÏó¹¤³§;

public class NFactory extends Factory{

	@Override
	public Screw createScrew(String ItemName, String type) {
		return new NScrew(ItemName, type);
	}

	@Override
	public SmallBox createSmallBox(String ItemName) {
		return new NSmallBox(ItemName);
	}

	@Override
	public PackBox createPackBox(String maker, String time) {
		return new NPackBox(maker, time);
	}

}
