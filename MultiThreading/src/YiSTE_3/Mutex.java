package YiSTE_3;

public final class Mutex {
	private boolean busy=false;//��־�ֱ�ʾ��Դ�Ƿ���������
	
	public synchronized void lock(){//���������ý�
		while(busy){//�����Դû���ý�14�С����������
			try {
				wait();//һֱ�ȴ���Դ�ͷ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		busy=true;//����
	}
	
	public synchronized void unlock(){//�������ý�
		busy=false;//��Դû������
		notifyAll();//���������߳�
	}
}
//���⣺1.��һ���߳����ε���lock��ڶ��β��ܽ����൱���Լ����Լ���������
//2.�����̶߳��ɵ���unlock�����Լ��ϵ���Ҳ�ܴ�