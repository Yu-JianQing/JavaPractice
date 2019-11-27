package ³éÏó¹¤³§;

public class MPackBox extends PackBox{

	public MPackBox(String maker, String time) {
		super(maker, time);
	}

	@Override
	public String makeProduct() {
		return "m packbox maker :"+maker+" time: "+time;
	}

}
