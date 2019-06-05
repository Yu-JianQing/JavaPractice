package JiuFu_5;

public class Main {
	public static void main(String[] args) {
		//以下是为解决异常捕获问题
		try {
			System.out.println("main beign");
			
			Host host=new Host();
			Data data=host.request(-1, 'a');
			System.out.println("data="+data.getContent());
			
			System.out.println("main end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
