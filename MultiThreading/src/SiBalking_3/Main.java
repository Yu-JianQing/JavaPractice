package SiBalking_3;

public class Main {
	public static void main(String[] args) {
		Thread testThread=new TestThread();
		while(true){
			testThread.start();//error,startֻ�ɵ���һ��
		}
	}
}
