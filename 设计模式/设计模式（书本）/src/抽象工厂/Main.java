package ���󹤳�;

public class Main {
	public static void main(String[] args) {
		
		Factory factory=Factory.getFactory("���󹤳�.NFactory");
		
		Screw screw=factory.createScrew("Xscrew", "1");
		SmallBox smallBox=factory.createSmallBox("smallBox");
		PackBox packBox=factory.createPackBox("tom", "2016-8-8");
		
		System.out.println(screw.makeProduct());
		System.out.println(smallBox.makeProduct());
		System.out.println(packBox.makeProduct());
		
		smallBox.add(screw);
		packBox.add(smallBox);
		packBox.end();
		
		packBox.print();
		
	}
}
