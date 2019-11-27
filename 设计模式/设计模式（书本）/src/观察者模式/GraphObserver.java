package 观察者模式;

public class GraphObserver implements Observer{

	@Override
	public void update(NumberGenerator generator) {
		System.out.println("GraphObserver--->"+generator.getNumber()+"******");
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {}
	}

}
