package QiTPM_5;

public class Blackhole2 {
	public static void enter(Object obj){
		System.out.println("Step1");
		magic(obj);
		System.out.println("Step2");
		synchronized (obj) {
			System.out.println("Step3 never reached here");
		}
	}
	
	public static void magic(Object obj){
		Thread thread=new Thread(){
			public void run(){
				synchronized (obj) {//��obj����
					synchronized (this) {//��Ϊ��Ҫ���step2����Ҫ�������߳�
						this.notifyAll();//����ҲҪ������Ӧ�������
					}
					try {
						this.join();//����obj��������
					} catch (InterruptedException e) {}
				}
			}
		};
		thread.start();
		synchronized (thread) {
			try {//Ϊ��֤���߳����õ��������Ƚ����̶߳���
				thread.wait();//����ǽ����̶߳�����thread����Ķ����У�waitʱҪ�Ȼ����Ӧ�������������ǰ�����synchronize��thread��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
