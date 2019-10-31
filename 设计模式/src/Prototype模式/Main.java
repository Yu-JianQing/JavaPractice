package Prototypeģʽ;

public class Main {
	public static void main(String[] args) {
		Pen pen=new Pen();
		Box box1=new Box();
		Box box2=new Box();
		
		Manger manger=new Manger();
		
		manger.register("pen", pen);
		manger.register("box1", box1);
		manger.register("box2", box2);
		
		Product p1=manger.createProduct("pen");
		p1.use("p1");
		Product p2=manger.createProduct("box1");
		p2.use("p2");
		Product p3=manger.createProduct("box2");
		p3.use("p3");
		
	}
}
