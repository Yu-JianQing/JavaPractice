package YiSTE_2;

//һ���߳���Ҫ��ȡ�����ͬ����Դ����ͨ����Դ�Ļ�ȡ˳��ͻ�ȡÿ����Դ����ʵ�ֻ���

public class CopyOfMain {
	public static void main(String[] args) {
		CopyOfTool spoon=new CopyOfTool("spoon");
		CopyOfTool fork=new CopyOfTool("fork");
		new CopyOfEaterThread("Tom", spoon, fork).start();
		//����ѧ�������е���������ѧ������ߵĿ��ӣ�ż������ѧ�����ұߵĿ��ӣ�
		//��ֻ�����ҿ��Ӷ��õ����ܳԷ�
		new CopyOfEaterThread("Jerry", spoon, fork).start();
	}
}
