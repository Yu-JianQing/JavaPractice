package JiuFu_5;

public class Main {
	public static void main(String[] args) {
		//������Ϊ����쳣��������
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
