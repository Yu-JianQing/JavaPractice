package ���󹤳�;

public class NPackBox extends PackBox{

	public NPackBox(String maker, String time) {
		super(maker, time);
	}

	@Override
	public String makeProduct() {
		return "n packbox maker :"+maker+" time: "+time;
	}

}
