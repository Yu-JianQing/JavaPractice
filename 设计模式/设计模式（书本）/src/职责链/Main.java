package Ö°ÔðÁ´;

public class Main {
	public static void main(String[] args) {
		Support tom=new NoSupport("tom"); 
		Support bob=new OddSupport("bob");
		Support jerry1=new LimitSupport("jerry1", 2);
		Support jerry2=new LimitSupport("jerry2", 4);
		Support alice=new SpecialSupport("alice", 6);
		Support jerry3=new LimitSupport("jerry3", 8);
		
		tom.setNext(bob).setNext(jerry1).setNext(jerry2).setNext(alice).setNext(jerry3);
		
		for(int i=0;i<10;i++)
			tom.support(new Trouble(i));
		
	}
}
