package 观察者模式;

public class Main {
	public static void main(String[] args) {
//		NumberGenerator generator=new RandomNumberGenerator();
		NumberGenerator generator=new IncrementalNumberGenerator(0, 10, 2);
		
		Observer observer1=new DigitObserver();
		Observer observer2=new GraphObserver();
		Observer observer3=new DisplayObserver();
		
		generator.addObserver(observer1);
		generator.addObserver(observer2);
		generator.addObserver(observer3);
		
		generator.execute();
		
	}
}
