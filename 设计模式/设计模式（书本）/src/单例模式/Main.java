package µ¥ÀýÄ£Ê½;

public class Main {
	public static void main(String[] args) {
		Single s1=Single.getSingle();
		Single s2=Single.getSingle();
		System.out.println(s1+"    "+s1.hashCode());
		System.out.println(s2+"    "+s2.hashCode());
		System.out.println(s1==s2);
	}
}
