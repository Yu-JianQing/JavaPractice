package ErImmu_4;

public class Main {
	public static void main(String[] args) {
		UserInfo info=new UserInfo("Tom", "Amercia");
		StringBuffer s1=info.getInfo();
		System.out.println(info.toString());
		System.out.println(info.hashCode());
		s1.append("sss");
		System.out.println(info.toString());
		System.out.println(info.hashCode());
	}
}
