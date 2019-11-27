package 工厂方法;

public class Main {
	public static void main(String[] args) {
		Factory factory=new IdCardFactory();
		Product p1=factory.create("tom");
		p1.use();
		Product p2=factory.create("jerry");
		p2.use();
		Product p3=factory.create("jack");
		p3.use();
	}
}
