package �۲���ģʽ;

public class DisplayObserver implements Observer{

	@Override
	public void update(NumberGenerator generator) {
		System.out.println("----"+generator.getNumber()+"----");
	}

}
