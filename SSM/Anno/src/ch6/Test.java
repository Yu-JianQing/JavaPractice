package ch6;

public class Test {
	public static void main(String[] args) {
		LoginBean bean=Container.getBean();
		bean.loginTest();
	}
}
