package Mementoģʽ;

public class Main {
	public static void main(String[] args) {
		Gramer tom=new Gramer(100);
		Memento m=tom.createMemento();
		
		for(int i=0;i<100;i++){
			System.out.println("tom current state is "+tom);
			tom.bet();
			
			if(tom.getMoney()>m.getMoney()){
				System.out.println("add money store this state");
				m=tom.createMemento();
			}else if(tom.getMoney()<m.money/2){
				System.out.println("down money restore before state");
				tom.restoreMemento(m);
			}
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
		
	}
}
