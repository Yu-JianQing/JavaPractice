package BaWT_4;

public class Main {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"  begin");
		new MyFrame();
		new MyFrame_2();
		System.out.println(Thread.currentThread().getName()+"  end");
	}
}
