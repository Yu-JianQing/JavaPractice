package Strategyģʽ;

public class Main {
	public static void main(String[] args) {
		
		Player tom=new Player("tom", new WinningStrategy(Hand.ShiTou));
//		Player jerry=new Player("jerry", new ProbStrategy(Hand.JianDao));
		Player jerry=new Player("jerry", new RandomStrategy());
		
		for(int i=0;i<200;i++){
			Hand tomNext=tom.nextHand();
			Hand jerryNext=jerry.nextHand();
			if(tomNext.isStrongerThan(jerryNext)){
				System.out.println("winner : "+tom);
				tom.win();
				jerry.loose();
			}else if(tomNext.isWeakerThan(jerryNext)){
				System.out.println("winner : "+jerry);
				jerry.win();
				tom.loose();
			}else {
				System.out.println("draw--------------");
				tom.draw();
				jerry.draw();
			}
		}
		
		System.out.println("total:");
		System.out.println(tom);
		System.out.println(jerry);
		
	}
}
