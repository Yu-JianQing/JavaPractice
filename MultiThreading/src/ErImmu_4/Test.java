package ErImmu_4;

public class Test {
	public static void main(String[] args) {
		Point point=new Point(0, 0);
		System.out.println(point);
		System.out.println(point.hashCode());
		point.x=1;
		System.out.println(point);
		System.out.println(point.hashCode());
	}
}
