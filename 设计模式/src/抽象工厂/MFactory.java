package ³éÏó¹¤³§;

public class MFactory extends Factory{

	@Override
	public Screw createScrew(String ItemName, String type) {
		return new MScrew(ItemName, type);
	}

	@Override
	public SmallBox createSmallBox(String ItemName) {
		return new MSmallBox(ItemName);
	}

	@Override
	public PackBox createPackBox(String maker, String time) {
		return new MPackBox(maker, time);
	}

}
